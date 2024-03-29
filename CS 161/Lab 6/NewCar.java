
public class NewCar extends Car {
	
	private double optionCost; // cost options to add to the base price
	private double rebate; // dealer rebate of new car
	private static int numOfNewcar; // number of instantiated NewCar objects
	private static double totalAssets; // total assets of all NewCar objects
	
	public NewCar() {
		super();
		optionCost = 0;
		rebate = 0;
		numOfNewcar++;
	}
	
	public NewCar(String eid, double eprice, int eyear, double ecommission, double eoption, double erebate) {
		super(eid, eprice, eyear, ecommission);
		this.optionCost = eoption;
		this.rebate = erebate;
		numOfNewcar++;
	}
	
	public double computeTotal() {
		// computes the total cost of the car: baseprice + options + commission - rebate
		double totalCost = this.baseprice + this.optionCost + this.commission - this.rebate;
		return totalCost;
	}
	
	public String goodBusiness() {
		// returns "Good" or "Bad" based on commission
		if(this.commission > 0.08 * this.baseprice) return "Good";
		else return "Bad";
	}
	
	public static int getNumOfNewcar() {
		// returns the number of instantiated NewCar objects
		return numOfNewcar;
	}
	
	public static double getTotalAssets() {
		// returns the assets of all NewCar objects
		return totalAssets;
	}
	
	public String toString() {
		// returns a string showing the values of each field
		return "New Car" + super.toString() + String.format("%nOption Cost = %.2f%nRebate = %.2f%nTotal Cost = %.2f%nDeal = %s", this.optionCost, this.rebate, this.computeTotal(), this.goodBusiness());
	}
	
	public void updateAssets() {
		// adds a NewCar object's assets to the Car and NewCar totals
		Car.addTotalAssets(this.computeTotal());
		totalAssets += this.computeTotal();
	}
	
	public double getMileage() {
		// returns the mileage of a new car (always 0)
		return 0.0;
	}
	
}
