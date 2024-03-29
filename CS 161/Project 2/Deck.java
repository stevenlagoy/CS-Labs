import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Deck
{
  public ArrayList<Card> cards = new ArrayList<Card>();
  
  public Deck() {
	this.reset();
  }
  
  public void reset() { // Clears a deck and populates it with 4 cards of each face.
	  
    this.cards.clear();
    for(int i = 0; i < 4; i++) {
      this.cards.add(new Card("A"));
      this.cards.add(new Card("2"));
      this.cards.add(new Card("3"));
      this.cards.add(new Card("4"));
      this.cards.add(new Card("5"));
      this.cards.add(new Card("6"));
      this.cards.add(new Card("7"));
      this.cards.add(new Card("8"));
      this.cards.add(new Card("9"));
      this.cards.add(new Card("10"));
      this.cards.add(new Card("J"));
      this.cards.add(new Card("Q"));
      this.cards.add(new Card("K"));
    }
    
  }
  
  public Card dealCard(){
    return cards.remove(new Random().nextInt(cards.size()));
  }
  
}