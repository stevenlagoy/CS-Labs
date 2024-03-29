import java.io.*;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class BlackjackTableGUI extends Application
{
  public static void main(String[] args){
	  launch(args);
  }
  
  static Deck deck = new Deck();
  static Player dealer = new Player();
  static Player player = new Player();
  
  static Button startButton = new Button("Start");    
  static Button hitButton = new Button("Hit");
  static Button standButton = new Button("Stand");
  
  static int playerscore = 0;
  static int dealerscore = 0;
  static Label playerscoreLabel = new Label("Player Score: 0");
  static Label dealerscoreLabel = new Label("Dealer Score: 0");
  
  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Blackjack");
    
    hitButton.setDisable(true);
    standButton.setDisable(true);
    
    startButton.setOnAction(e -> {
    	hitButton.setDisable(true);
    	standButton.setDisable(true);
    	startGame();
    });

    Label dealerhandLabel = new Label("Dealer Hand");
    Label dealervalueLabel = new Label("Value: 0");
    
    HBox dealerCardsBox = new HBox();
    dealerCardsBox.getChildren().addAll(dealer.getHand());
    
    Label playerhandLabel = new Label("Player Hand");
    Label playervalueLabel = new Label("Value: 0");
    
    HBox playerCardsBox = new HBox();
    playerCardsBox.getChildren().addAll(player.getHand());
    
    HBox buttonsBox = new HBox(startButton, hitButton, standButton);
    
    Scene primaryScene = new Scene(buttonsBox);
    primaryStage.setScene(primaryScene);
    primaryStage.show();
    
  }
  
  public void startGame() {
	  deck.reset();
	  dealer.clearHand();
	  player.clearHand();
	  dealer.hit();
	  startButton.setDisable(true);
	  hitButton.setDisable(false);
  	  standButton.setDisable(false);
  	  // TODO clear previous game result
  }
  
  public void updateHand(Player p, HBox box, Label handValue) {
	  box.getChildren().clear();
	  //box.getChildren().addAll(p.getHand());
	  handValue.setText(Integer.toString(p.valueOfHand()));
  }
  
  public void endGame() {
	  if(!player.bust() && dealer.bust()) { // the player did not bust and the dealer did
		  playerscoreLabel.setText(String.format("Player Score: %d", ++playerscore));
	  }
	  else if(player.bust() && !dealer.bust()) { // the player busted and the dealer did not
		  dealerscoreLabel.setText(String.format("Dealer Score: %d", ++dealerscore));
	  }
	  else if(player.valueOfHand() > dealer.valueOfHand()) { // the player scored higher than the dealer
		  playerscoreLabel.setText(String.format("Player Score: %d", ++playerscore));
	  }
	  else if(player.valueOfHand() > dealer.valueOfHand()) { // the player scored lower than the dealer
		  dealerscoreLabel.setText(String.format("Dealer Score: %d", ++dealerscore));
	  }
	  else { // the game was tied / was a push
	  }
  }
  
}