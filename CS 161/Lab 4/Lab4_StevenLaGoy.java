import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import javafx.scene.canvas.*;
import javafx.scene.web.*;
import javafx.scene.shape.*;
import javafx.geometry.*;

public class ColorSelectionGUI extends Application {

	public static void main(String[] args) {
		
		// launch the application
		launch(args);
		
	}
	
	@Override
	public void start(Stage primaryStage){
		
		primaryStage.setTitle("Color Selection");
		
		// create labels for cardinal directions
		Label northLabel = new Label("North");
		northLabel.setAlignment(Pos.CENTER);
		Label eastLabel = new Label("East");
		eastLabel.setAlignment(Pos.CENTER);
		Label southLabel = new Label("South");
		southLabel.setAlignment(Pos.CENTER);
		Label westLabel = new Label("West");
		westLabel.setAlignment(Pos.CENTER);
		
		// create checkboxes for directions
		Label locationsLabel = new Label("Locations");
		locationsLabel.setStyle("-fx-font-weight: bold");
		
		CheckBox northBox = new CheckBox("North");
		northBox.setSelected(true);
		CheckBox eastBox = new CheckBox("East");
		eastBox.setSelected(true);
		CheckBox southBox = new CheckBox("South");
		southBox.setSelected(true);
		CheckBox westBox = new CheckBox("West");
		westBox.setSelected(true);
		
		// create radio buttons for colors and register event handlers for each
		
		ToggleGroup toggleGroup = new ToggleGroup();
		
		Label colorsLabel = new Label("Background Colors");
		colorsLabel.setStyle("-fx-font-weight: bold");
		
		RadioButton salmonButton = new RadioButton("Salmon");
		salmonButton.setStyle("-fx-text-fill: salmon");
		salmonButton.setOnAction(e -> {
			if(northBox.isSelected())
				northLabel.setStyle("-fx-background-color: salmon");
			if(eastBox.isSelected())
				eastLabel.setStyle("-fx-background-color: salmon");
			if(southBox.isSelected())
				southLabel.setStyle("-fx-background-color: salmon");
			if(westBox.isSelected())
				westLabel.setStyle("-fx-background-color: salmon");
		});
		salmonButton.setToggleGroup(toggleGroup);
		
		RadioButton greenButton = new RadioButton("Spring Green");
		greenButton.setStyle("-fx-text-fill: springgreen");
		greenButton.setOnAction(e -> {
			if(northBox.isSelected())
				northLabel.setStyle("-fx-background-color: springgreen");
			if(eastBox.isSelected())
				eastLabel.setStyle("-fx-background-color: springgreen");
			if(southBox.isSelected())
				southLabel.setStyle("-fx-background-color: springgreen");
			if(westBox.isSelected())
				westLabel.setStyle("-fx-background-color: springgreen");
		});
		greenButton.setToggleGroup(toggleGroup);
		
		RadioButton orangeButton = new RadioButton("Orange");
		orangeButton.setStyle("-fx-text-fill: orange");
		orangeButton.setOnAction(e -> {
			if(northBox.isSelected())
				northLabel.setStyle("-fx-background-color: orange");
			if(eastBox.isSelected())
				eastLabel.setStyle("-fx-background-color: orange");
			if(southBox.isSelected())
				southLabel.setStyle("-fx-background-color: orange");
			if(westBox.isSelected())
				westLabel.setStyle("-fx-background-color: orange");
		});
		orangeButton.setToggleGroup(toggleGroup);
		
		RadioButton cyanButton = new RadioButton("Cyan");
		cyanButton.setStyle("-fx-text-fill: cyan");
		cyanButton.setOnAction(e -> {
			if(northBox.isSelected())
				northLabel.setStyle("-fx-background-color: cyan");
			if(eastBox.isSelected())
				eastLabel.setStyle("-fx-background-color: cyan");
			if(southBox.isSelected())
				southLabel.setStyle("-fx-background-color: cyan");
			if(westBox.isSelected())
				westLabel.setStyle("-fx-background-color: cyan");
		});
		cyanButton.setToggleGroup(toggleGroup);
		cyanButton.setSelected(true);
		
		GridPane gridPane = new GridPane();
		gridPane.add(locationsLabel, 0, 0);
		gridPane.add(northBox, 0, 1);
		gridPane.add(southBox, 0, 2);
		gridPane.add(eastBox, 0, 3);
		gridPane.add(westBox, 0, 4);
		gridPane.add(colorsLabel, 1, 0);
		gridPane.add(salmonButton, 1, 1);
		gridPane.add(greenButton, 1, 2);
		gridPane.add(orangeButton, 1, 3);
		gridPane.add(cyanButton, 1, 4);
		
		gridPane.setPrefSize(220, 160);
		gridPane.setHgap(15.0);
		gridPane.setVgap(4.0);
		gridPane.setPadding(new Insets(5));
		
		// create a border pane for each direction
		BorderPane borderPane = new BorderPane(gridPane, northLabel, eastLabel, southLabel, westLabel);
		borderPane.setAlignment(gridPane, Pos.CENTER);
		borderPane.setAlignment(northLabel, Pos.CENTER);
		borderPane.setAlignment(eastLabel, Pos.CENTER);
		borderPane.setAlignment(southLabel, Pos.CENTER);
		borderPane.setAlignment(westLabel, Pos.CENTER);
		
		Scene scene = new Scene(borderPane);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		cyanButton.fireEvent(new ActionEvent());
		
		// set the sizes of some labels
		northLabel.setPrefSize(primaryStage.getWidth(), 40);
		southLabel.setPrefSize(primaryStage.getWidth(), 40);
		eastLabel.setPrefSize(40, primaryStage.getHeight());
		westLabel.setPrefSize(40, primaryStage.getHeight());
	}
	
}
