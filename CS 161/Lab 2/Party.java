
public class Party {
	
	private Hero[] Heroes; // list to hold up to three heroes in the party
	
	public Party() {
		this.Heroes = new Hero[3];
	}
	
	public void addHero(int index, Hero hero) {
		Heroes[index] = hero;
	}
	public Hero removeHero(int index) {
		Hero hero = this.getHero(index);
		Heroes[index] = null;
		return hero;
	}
	public Hero getHero(int index) {
		return Heroes[index];
	}
	public void gainExperience(int experience) {
		for(Hero hero : Heroes) {
			hero.gainExperience(experience);
		}
	}
	public String toString() { // overload toString to print each characters info
		String returnString = "\nParty\n-----------------\n";
		for(Hero hero : Heroes) {
			returnString += hero.toString();
			returnString += "\n";
		}
		return returnString;
	}
}
