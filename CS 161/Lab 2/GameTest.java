import java.util.Scanner;

public class GameTest {
	
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		final String[] CLASSES = {"Mage", "Ranger", "Brawler", "Healer"};
		
		// make a list of hero objects
		Hero[] heroes = new Hero[4];
		heroes[0] = new Hero("John");
		heroes[1] = new Hero("Bill");
		heroes[2] = new Hero("Todd");
		heroes[3] = new Hero("Zorbius, Defender of the Weak");

		// ask the user to define the classes for each character
		for(Hero hero : heroes) {
			System.out.println("Select a class for " + hero.getName());
			// print the classes as a menu
			for(int i = 0; i < CLASSES.length; i++) {
				System.out.println((i+1) + "- " + CLASSES[i]);
			}
			// get the users input and apply the selected hero class to the character
			do {
				System.out.print("Enter Class Name or Number: ");
				String input = keyboard.nextLine();
				if(input.equals("1") || input.equals(CLASSES[0]))
					hero.setHClass(CLASSES[0]);
				else if(input.equals("2") || input.equals(CLASSES[1]))
					hero.setHClass(CLASSES[1]);
				else if(input.equals("3") || input.equals(CLASSES[2]))
					hero.setHClass(CLASSES[2]);
				else if(input.equals("4") || input.equals(CLASSES[3]))
					hero.setHClass(CLASSES[3]);
				else
					System.out.println("Please enter a valid class name or number.");
			} while(hero.getHClass().equals(""));
			System.out.print("\n");
		}
		
		// create the party and fill it with hero objects
		Party party1 = new Party();
		party1.addHero(0, heroes[0]);
		party1.addHero(1, heroes[1]);
		party1.addHero(2, heroes[2]);
		
		// add some experience to test the functions
		heroes[0].setRandomLevel();
		heroes[1].gainExperience(30);
		heroes[2].gainExperience(100);
		heroes[3].gainExperience(1000000);
		
		// print their stats
		System.out.println(party1.toString());
		
		// swap one hero with another and text experience again
		party1.addHero(1, heroes[3]);
		party1.gainExperience(20);
		
		// print their stats
		System.out.println(party1.toString());
		
		keyboard.close();
	}
	
}
