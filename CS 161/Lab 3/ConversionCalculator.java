import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class ConversionCalculator extends Application {
  
  // values for conversions between units
  private final float INtoCM = 2.54f;
  private final float INtoYD = 0.0278f;
  private final float CMtoM = 0.01f;
  private final float CMtoIN = 0.3937f;
  private final float YDtoIN = 36.0f;
  private final float MtoCM = 100.0f;
  private final float CMtoYD = 0.0109f;
  private final float MtoIN = 39.37f;
  private final float MtoYD = 1.094f;
  private final float INtoM = 0.0254f;
  private final float YDtoCM = 91.44f;
  private final float YDtoM = 0.9144f;
  
	
  public static void main(String[] args){
    
    
    // launch the application
    launch(args);
    
  }
  
  // create text fields so they can be changed by events
  private TextField cmField = new TextField("0.00");
  private TextField mField = new TextField("0.00");
  private TextField inField = new TextField("0.00");
  private TextField ydField = new TextField("0.00");
  
  @Override
  public void start(Stage primaryStage){
    
    primaryStage.setTitle("Conversion Calculator");
    
    // create a label and field for centimeters
    Label cmLabel = new Label("Centimeters:");
    cmLabel.setPrefSize(80, 45);
    cmField.setPrefSize(230, 45);
    
    // create a label and field for meters
    Label mLabel = new Label("Meters:");
    mLabel.setPrefSize(80, 45);
    mField.setPrefSize(230, 45);
    
    // create a label and field for inches
    Label inLabel = new Label("Inches:");
    inLabel.setPrefSize(80, 45);
    inField.setPrefSize(230, 45);
    
    // create a label and field for yards
    Label ydLabel = new Label("Yards:");
    ydLabel.setPrefSize(80, 45);
    ydField.setPrefSize(230, 45);
    
    // create buttons
    
    // create clear button
    Button clearButton = new Button("Clear");
    clearButton.setPrefSize(80, 15);
    // register event handler
    clearButton.setOnAction(new ClearButtonHandler());
    
    // create calculate button
    Button calcButton = new Button("Calculate");
    calcButton.setPrefSize(80, 15);
    // register event handler
    calcButton.setOnAction(new CalculateButtonHandler());
    
    // create exit button
    Button exitButton = new Button("Exit");
    exitButton.setPrefSize(80, 15);
    // register event handler
    exitButton.setOnAction(new ExitButtonHandler());
    
    // create hboxes for each element group
    HBox cmBox = new HBox(cmLabel, cmField);
    HBox mBox = new HBox(mLabel, mField);
    HBox inBox = new HBox(inLabel, inField);
    HBox ydBox = new HBox(ydLabel, ydField);
    
    GridPane gridpane = new GridPane();
    gridpane.setVgap(25);
    gridpane.setPadding(new Insets(10));
    gridpane.add(cmBox, 0, 0);
    gridpane.add(mBox, 1, 0);
    gridpane.add(inBox, 0, 1);
    gridpane.add(ydBox, 1, 1);
    
    VBox vbox = new VBox(20, clearButton, calcButton, exitButton);
    vbox.setPadding(new Insets(10));
    vbox.setAlignment(Pos.CENTER);
    
    HBox hbox = new HBox(gridpane, vbox);
    
    Scene scene = new Scene(hbox);
    
    primaryStage.setScene(scene);
    primaryStage.show();
    
  }
  
  class CalculateButtonHandler implements EventHandler<ActionEvent>{
	  @Override
	  public void handle(ActionEvent event){
		if(!cmField.getText().equals("0.0")) {
		    cmField.setText(String.format("%.2f", round(Float.parseFloat(cmField.getText()) * 1.0f)));
		    mField.setText(String.format("%.2f", round(Float.parseFloat(cmField.getText()) * CMtoM)));
		    inField.setText(String.format("%.2f", round(Float.parseFloat(cmField.getText()) * CMtoIN)));
		    ydField.setText(String.format("%.2f", round(Float.parseFloat(cmField.getText()) * CMtoYD)));
		}
		else if(!mField.getText().equals("0.0")) {
			cmField.setText(String.format("%.2f", round(Float.parseFloat(mField.getText()) * MtoCM)));
		    mField.setText(String.format("%.2f", round(Float.parseFloat(mField.getText()) * 1.0f)));
		    inField.setText(String.format("%.2f", round(Float.parseFloat(mField.getText()) * MtoIN)));
		    ydField.setText(String.format("%.2f", round(Float.parseFloat(mField.getText()) * MtoYD)));
		}
		else if(!inField.getText().equals("0.0")) {
			cmField.setText(String.format("%.2f", round(Float.parseFloat(inField.getText()) * INtoCM)));
		    mField.setText(String.format("%.2f", round(Float.parseFloat(inField.getText()) * INtoM)));
		    inField.setText(String.format("%.2f", round(Float.parseFloat(inField.getText()) * 1.0f)));
		    ydField.setText(String.format("%.2f", round(Float.parseFloat(inField.getText()) * INtoYD)));
		}
		else if(!ydField.getText().equals("0.0")) {
			cmField.setText(String.format("%.2f", round(Float.parseFloat(ydField.getText()) * YDtoCM)));
		    mField.setText(String.format("%.2f", round(Float.parseFloat(ydField.getText()) * YDtoM)));
		    inField.setText(String.format("%.2f", round(Float.parseFloat(ydField.getText()) * YDtoIN)));
		    ydField.setText(String.format("%.2f", round(Float.parseFloat(ydField.getText()) * 1.0f)));
		}	
	  }
  }
  
  class ClearButtonHandler implements EventHandler<ActionEvent>{
	  @Override
	  public void handle(ActionEvent event){
	    cmField.setText("0.0");
	    mField.setText("0.0");
	    inField.setText("0.0");
	    ydField.setText("0.0");
	  }
  }
  
  class ExitButtonHandler implements EventHandler<ActionEvent>{
	  @Override
	  public void handle(ActionEvent event){
	    Platform.exit();
	  }
  }
  
  public static float round(float num){
    return (float) (Math.round(num * 100.0) / 100.0);
  }

}