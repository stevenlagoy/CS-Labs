
public abstract class Car {

	private String id; // vehicle id
	private int year = 2007; // model year of car
	protected double baseprice; // base price of car
	protected double commission; // commission of selling car
	protected static double totalAssets; // total assets of the dealer
	
	public Car() {
		this.id = "";
		this.year = 2007;
		this.baseprice = 0.0;
		this.commission = 0.0;
	}
	public Car(String eid, double eprice, int eyear, double ecommission) {
		this.id = eid;
		this.year = eyear;
		this.baseprice = eprice;
		this.commission = ecommission;
	}
	
	public static double getTotalAssets() {
		// returns the total assets of the dealer
		return totalAssets;
	}
	
	public static void addTotalAssets(double asset){
		// adds an input value to the assets of the dealer
		totalAssets += asset;
	}
	
	public String toString() {
		// returns a string showing the values of each field
		return String.format("%nVehicle ID = %s%nModel year = %d%nBase price = %.2f%nCommission = %.2f", this.id, this.year, this.baseprice, this.commission);
	}
	
	// abstract classes for Car subclasses
	
	public abstract void updateAssets();
	
	public abstract double getMileage();
	
	public abstract String goodBusiness();
}
