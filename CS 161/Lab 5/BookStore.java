import java.io.*;
import java.util.Scanner;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class BookStore extends Application
{
  
  public static void main(String[] args)
  {
    
    launch(args);
    
  }
    
  @Override
  public void start(Stage primaryStage) throws IOException
  {
    
    primaryStage.setTitle("Book Store Shopping Cart");
    
    Label welcomeLabel = new Label("Welcome to the PFW Online Book Store!");
    
    Label availableBooksLabel = new Label("Available Books");
    ListView<Book> availableList = new ListView<Book>();
    VBox availableBox = new VBox(availableBooksLabel, availableList);
    
    Label shoppingCartLabel = new Label("Shopping Cart");
    ListView cartList = new ListView();
    VBox cartBox = new VBox(shoppingCartLabel, cartList);
    
    // create the menu bar ------------------------------------------------------------------------
    
    Menu fileMenu = new Menu("File");
    MenuItem loadBooks = new MenuItem("Load Books");
    loadBooks.setOnAction(e -> {
      FileChooser fileChooser = new FileChooser();
      File projectDirectory = new File(System.getProperty("user.dir"));
      fileChooser.setInitialDirectory(projectDirectory);
      File selectedFile = fileChooser.showOpenDialog(primaryStage);
      if(selectedFile != null){ // if the user selected a file
        Scanner scanner;
		try {
			scanner = new Scanner(selectedFile);
	        while(scanner.hasNext()){
	          String[] bookString = scanner.nextLine().split(", ");
	          availableList.getItems().addAll(new Book(bookString[0], Double.parseDouble(bookString[1])));
	        }
		} catch (FileNotFoundException e1) {}
      }
    });
    MenuItem exit = new MenuItem("Exit");
    exit.setOnAction(e -> Platform.exit());
    fileMenu.getItems().addAll(loadBooks, exit);
    
    Menu shoppingMenu = new Menu("Shopping");
    MenuItem addBook = new MenuItem("Add Selected Book");
    addBook.setOnAction(e -> {
    	if(availableList.getSelectionModel().getSelectedItem() != null)
    		cartList.getItems().add(availableList.getSelectionModel().getSelectedItem());
    });
    MenuItem removeBook = new MenuItem("Remove Selected Book");
    removeBook.setOnAction(e -> {
    	cartList.getItems().remove(cartList.getSelectionModel().getSelectedItem());
    });
    MenuItem clearCart = new MenuItem("Clear Cart");
    clearCart.setOnAction(e -> {
    	cartList.getItems().clear();
    });
    MenuItem checkOut = new MenuItem("Check Out");
    checkOut.setOnAction(e -> {
    	double subtotal = 0.0;
    	double taxRate = 0.07;
    	double taxAmt = 0.0;
    	double totalCost = 0.0;
    	
    	for(int i = 0; i < cartList.getItems().size(); i++) {
    		subtotal += 1;
    	}
    	taxAmt = subtotal * taxRate;
    	totalCost = subtotal + taxAmt;
    	
    	Label subtotalLabel = new Label(String.format("Subtotal: %.2f", subtotal));
    	Label taxAmtLabel = new Label(String.format("Tax: %.2f", taxAmt));
    	Label totalCostLabel = new Label(String.format("Total: %.2f", totalCost));
    	Button okButton = new Button("OK");
    	okButton.setOnAction(e1 -> {
    		Platform.exit();
    	});
    	VBox costBox = new VBox(subtotalLabel, taxAmtLabel, totalCostLabel, okButton);
    	costBox.setPrefWidth(200);
    	Scene checkoutScene = new Scene(costBox);
    	Stage checkoutStage = new Stage();
    	checkoutStage.setScene(checkoutScene);
    	checkoutStage.show();
    });
    shoppingMenu.getItems().addAll(addBook, removeBook, clearCart, checkOut);
    
    MenuBar menuBar = new MenuBar(fileMenu, shoppingMenu);
    
    // create and show the window -----------------------------------------------------------------
    
    HBox booksInterfaceBox = new HBox(availableBox, cartBox);
    
    VBox sceneBox = new VBox(menuBar, welcomeLabel, booksInterfaceBox);
    
    Scene scene = new Scene(sceneBox);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
}