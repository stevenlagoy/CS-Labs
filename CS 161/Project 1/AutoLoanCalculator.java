/*
 * AUTO LOAN CALCULATOR
 * Project 1 - CS 161
 * Steven LaGoy
 * 24 February 2024
 */

// import needed javafx modules
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.text.TextAlignment; // tried to use this to right-align some text

public class AutoLoanCalculator extends Application {

	public static void main(String[] args) {
		
		// run the application
		launch(args);
		
	}
	
	// used by several event handlers - must be static variable
	static double annualInterest = 7.0;
	
	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.setTitle("Auto Loan Calculator");
		
		// create the payment info section --------------------------------------------------------
		GridPane paymentInfoGrid = new GridPane();
		paymentInfoGrid.setStyle("-fx-border-color:black"); // give it a black border
		paymentInfoGrid.setHgap(50);
		paymentInfoGrid.setVgap(10);
		paymentInfoGrid.setPadding(new Insets(5));
		
		Label paymentInfoLabel = new Label("Payment Information");
		paymentInfoLabel.setStyle("-fx-font-weight: bold");
		paymentInfoGrid.add(paymentInfoLabel, 0, 0);
		
		Label totalAmtLabel = new Label("Total Loan Amount: $");
		paymentInfoGrid.add(totalAmtLabel, 0, 1);
		Label totalAmtValue = new Label("0.0");
		totalAmtValue.setAlignment(Pos.CENTER_RIGHT);
		paymentInfoGrid.add(totalAmtValue, 1, 1);
		
		Label monthlyPayLabel = new Label("Monthly Payment: $");
		paymentInfoGrid.add(monthlyPayLabel, 0, 2);
		Label monthlyPayValue = new Label("0.0");
		monthlyPayValue.setAlignment(Pos.CENTER_RIGHT);
		paymentInfoGrid.add(monthlyPayValue, 1, 2);
		
		Label totalPayLabel = new Label("Total Payment: $");
		paymentInfoGrid.add(totalPayLabel, 0, 3);
		Label totalPayValue = new Label("0.0");
		totalPayValue.setAlignment(Pos.CENTER_RIGHT);
		paymentInfoGrid.add(totalPayValue, 1, 3);
		
		// create the loan term section -----------------------------------------------------------
		Label loanTermLabel = new Label("Loan Term");
		loanTermLabel.setStyle("-fx-font-weight: bold");
		
		ToggleGroup monthsButtonsGroup = new ToggleGroup();
		
		RadioButton months24Button = new RadioButton("24 Months");
		months24Button.setToggleGroup(monthsButtonsGroup);
		months24Button.setSelected(true);
		months24Button.setOnAction(e -> annualInterest = 7.0);
		RadioButton months36Button = new RadioButton("36 Months");
		months36Button.setToggleGroup(monthsButtonsGroup);
		months36Button.setOnAction(e -> annualInterest = 6.0);
		RadioButton months48Button = new RadioButton("48 Months");
		months48Button.setToggleGroup(monthsButtonsGroup);
		months48Button.setOnAction(e -> annualInterest = 5.5);
		RadioButton months60Button = new RadioButton("60 Months");
		months60Button.setToggleGroup(monthsButtonsGroup);
		months60Button.setOnAction(e -> annualInterest = 5.0);
		
		VBox loanTermBox = new VBox(10, loanTermLabel, months24Button, months36Button, months48Button, months60Button);
		loanTermBox.setStyle("-fx-border-color:black"); // give it a black border
		loanTermBox.setPadding(new Insets(5));
		
		// create the financing info section ------------------------------------------------------
		GridPane financingInfoGrid = new GridPane();
		financingInfoGrid.setStyle("-fx-border-color:black"); // give it a black border
		financingInfoGrid.setVgap(10);
		financingInfoGrid.setPadding(new Insets(5));
		
		Label financingInfoLabel = new Label("Financing Information");
		financingInfoLabel.setStyle("-fx-font-weight: bold");
		financingInfoGrid.add(financingInfoLabel, 0, 0); 
		
		Label basePriceLabel = new Label("Base Price: $");
		financingInfoGrid.add(basePriceLabel, 0, 1);
		TextField basePriceField = new TextField("0.0");
		financingInfoGrid.add(basePriceField, 1, 1);
		
		Label downPayLabel = new Label("Down Payment: $");
		financingInfoGrid.add(downPayLabel, 0, 2);
		TextField downPayField = new TextField("0.0");
		financingInfoGrid.add(downPayField, 1, 2);
		
		Label salesTaxLabel = new Label("Sales Tax: %");
		financingInfoGrid.add(salesTaxLabel, 0, 3);
		TextField salesTaxField = new TextField("7.0");
		financingInfoGrid.add(salesTaxField, 1, 3);
				
		// create the pricing options section -----------------------------------------------------
		Label priceOptionsLabel = new Label("Price with Options");
		priceOptionsLabel.setStyle("-fx-font-weight: bold");
		
		CheckBox autoTransmissionCheck = new CheckBox("Auto Transmission: $1800");
		CheckBox antiLockBrakeCheck = new CheckBox("Anti-Lock Brake: $1200");
		antiLockBrakeCheck.setSelected(true);
		CheckBox sunRoofCheck = new CheckBox("Sun Roof: $800");
		CheckBox navigationSystemCheck = new CheckBox("Navigation System: $1350");
		CheckBox audioPackageCheck = new CheckBox("Audio Package: $1550");
		
		VBox priceOptionsBox = new VBox(10, priceOptionsLabel, autoTransmissionCheck, antiLockBrakeCheck, sunRoofCheck, navigationSystemCheck, audioPackageCheck);
		priceOptionsBox.setStyle("-fx-border-color:black"); // give it a black border
		priceOptionsBox.setPadding(new Insets(5));
		
		// create the section for the 3 buttons ---------------------------------------------------
		Button calculateButton = new Button("Calculate");
		calculateButton.setPrefWidth(80);
		calculateButton.setStyle("-fx-font-weight: bold");
		// create the calculate button and its event handler
		calculateButton.setOnAction(e -> {
			double tax = ( // ternary operations to check the selected extra options
					Double.parseDouble(basePriceField.getText()) -
					Double.parseDouble(downPayField.getText()) +
					(autoTransmissionCheck.isSelected() ? 1800.0 : 0.0) +
					(antiLockBrakeCheck.isSelected() ? 1200.0 : 0.0) + 
					(sunRoofCheck.isSelected() ? 800.0 : 0.0) +
					(navigationSystemCheck.isSelected() ? 1350.0 : 0.0) +
					(audioPackageCheck.isSelected() ? 1550.0 : 0.0)
			) * Double.parseDouble(salesTaxField.getText()) / 100; // make it a percentage
			
			double loanAmount = ( // ternary operations to check the selected extra options
					Double.parseDouble(basePriceField.getText()) -
					Double.parseDouble(downPayField.getText()) +
					(autoTransmissionCheck.isSelected() ? 1800.0 : 0.0) +
					(antiLockBrakeCheck.isSelected() ? 1200.0 : 0.0) + 
					(sunRoofCheck.isSelected() ? 800.0 : 0.0) +
					(navigationSystemCheck.isSelected() ? 1350.0 : 0.0) +
					(audioPackageCheck.isSelected() ? 1550.0 : 0.0) +
					tax
			);
			
			int months;
			if(months36Button.isSelected()) months = 36;
			else if(months48Button.isSelected()) months = 48;
			else if(months60Button.isSelected()) months = 60;
			else months = 24;
			
			double monthlyInterest = annualInterest / 12 / 100; // make it a percentage
			
			double monthlyPayment = loanAmount * (monthlyInterest * Math.pow(1 + monthlyInterest, months)) / (Math.pow(1 + monthlyInterest, months) - 1);
			
			double totalPayment = monthlyPayment * (double) months + Double.parseDouble(downPayField.getText());
			
			totalAmtValue.setText(String.format("%.2f", loanAmount)); // print out the amount with two decimal places
			monthlyPayValue.setText(String.format("%.2f", monthlyPayment)); // print out the amount with two decimal places
			totalPayValue.setText(String.format("%.2f", totalPayment)); // print out the amount with two decimal places
		});
		// create the reset button and its event handler
		Button resetButton = new Button("Reset");
		resetButton.setPrefWidth(80);
		resetButton.setStyle("-fx-font-weight: bold");
		resetButton.setOnAction(e -> {
			totalAmtValue.setText("0.0");
			monthlyPayValue.setText("0.0");
			totalPayValue.setText("0.0");
			months24Button.setSelected(true); // also sets all other radio buttons in the control group to false
			basePriceField.setText("0.0");
			downPayField.setText("0.0");
			salesTaxField.setText("7.0");
			autoTransmissionCheck.setSelected(false);
			antiLockBrakeCheck.setSelected(true);
			sunRoofCheck.setSelected(false);
			navigationSystemCheck.setSelected(false);
			audioPackageCheck.setSelected(false);
		});
		// create the exit button and its event handler
		Button exitButton = new Button("Exit");
		exitButton.setPrefWidth(80);
		exitButton.setStyle("-fx-font-weight: bold");
		exitButton.setOnAction(e -> {
			Stage stage = (Stage) exitButton.getScene().getWindow();
			stage.close();
			System.exit(0);
		});
		// lay the controls out horizontally
		HBox controlsBox = new HBox(20, calculateButton, resetButton, exitButton);
		controlsBox.setAlignment(Pos.CENTER);
		controlsBox.setPadding(new Insets(5));
		
		// lay everything out ---------------------------------------------------------------------
		GridPane sceneGrid = new GridPane(); // grid for the first four sections
		sceneGrid.add(paymentInfoGrid, 0, 0);
		sceneGrid.add(loanTermBox, 1, 0);
		sceneGrid.add(financingInfoGrid, 0, 1);
		sceneGrid.add(priceOptionsBox, 1, 1);
		
		VBox sceneBox = new VBox(sceneGrid, controlsBox); // box to hold the grid and the controls
		
		// create and show the scene
		Scene scene = new Scene(sceneBox);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
