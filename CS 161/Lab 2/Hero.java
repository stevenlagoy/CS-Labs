import java.util.Random;

public class Hero {
	
	private String name;
	private String hClass;
	private int level;
	private int experience;
	private final int MAX_LEVEL = 10;
	private final int[] LEVELS = {5, 10, 15, 20, 30, 40, 50, 75, 100, 150};
	
	public Hero(String name) {
		this.name = name;
		this.hClass = "";
		this.level = 1;
		this.experience = 0;
	}
	
	public String getName() {
		return this.name;
	}
	public String getHClass() {
		return this.hClass;
	}
	public int getLevel() {
		return this.level;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setHClass(String hClass) {
		this.hClass = hClass;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	public void setRandomLevel() {
		Random rand = new Random();
		this.level = rand.nextInt(10);
	}
	public void gainExperience(int experience) {
		this.experience += experience;
		try {
			while(this.experience >= LEVELS[level-1] && level < MAX_LEVEL) {
				// as long as there is enough experience to level up and the character is not max level
				this.experience -= LEVELS[level-1]; // reduce the experience by the appropriate amount
				level++; // increase the level
				System.out.println(this.name + " has reached level " + this.level + "!");
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
			// do nothing
		}
	}
	public String toString() { // overload toString to print information about the character
		return String.format("%s is a level %d %s with %d experience.", this.name, this.level, this.hClass, this.experience);
	}
	
}
