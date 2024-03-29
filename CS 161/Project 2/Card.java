import java.io.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class Card extends ImageView
{

  public static String[] faces = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
  public static final int HEIGHT = 130;
  
  private String face;
  public Card(String face) {
	  super(new Image(new FileInputStream("/cards/" + face + ".png")));
	  super.setPreserveRatio(true);
	  super.setFitHeight(HEIGHT);
	  this.face = face;
  }
  
  public String getFace() {
	  return this.face;
  }
  
  public int valueOf() {
	  switch (this.getFace()){
	  	case "A": return 11;
	    case "2": return 2;
	    case "3": return 3;
	    case "4": return 4;
	    case "5": return 5;
	    case "6": return 6;
	    case "7": return 7;
	    case "8": return 8;
	    case "9": return 9;
	    case "10":
	    case "J":
	    case "Q":
	    case "K":
	      return 10;
	    default:
	      System.out.printf("Invalid card face: %s", this.getFace());
	      return -1;
	  }
  }
  
}