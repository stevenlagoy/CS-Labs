import java.util.ArrayList;
import java.util.Random;

public class Player
{
  public static Deck deck = new Deck();
  
  private ArrayList<Card> hand = new ArrayList<Card>();
  
  public Player(){
	  this.hand.addAll(new Deck().cards);
  }
  
  public Card[] getHand() {
	  return this.hand.toArray(new Card[this.hand.size()]);
  }
  
  public int valueOfHand() {
	  int total = 0;
	  for(Card card : this.hand) {
		  total += card.valueOf();
	  }
	  int numAces = 0;
	  for(Card card : this.hand) { // count the player's aces
		  if(card.getFace().equals("A")) {
			  numAces++;
		  }
	  }
	  while(total > 21 && numAces > 0) { // if the hand total is a bust and the player has aces
		  total -= 10; // make the value of the ace 1 instead of 11
		  numAces--;
	  } // repeats for each ace until the total is less than 21
	  return total;
  }
  
  public void clearHand() {
	  this.hand.clear();
  }
  
  public boolean stand(int otherPlayerValue) {
	  Random randy = new Random();
	  if(this.valueOfHand() > otherPlayerValue) {
		  return true;
	  }
	  else if(this.valueOfHand() >= 19) {
		  return true;
	  }
	  else if(this.valueOfHand() > 16 && randy.nextInt(1) == 1) {
		  return true;
	  }
	  return false;
  }
  
  public void hit() {
	  this.hand.add(deck.dealCard());
  }
  
  public boolean bust() {
	  return this.valueOfHand() > 21;
  }
  
}