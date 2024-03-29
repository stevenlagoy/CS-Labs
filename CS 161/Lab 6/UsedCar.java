
public class UsedCar extends Car {
	
	private double mileage; // mileage of a used car
	private double rateOfDepreciation; // depreciation rate of a used car ($ / year)
	private static int numOfUsedcar; // number of instantiated UsedCar objects
	private static double totalAssets; // total assets of all UsedCar objects
	
	public UsedCar() {
		super();
		mileage = 0.0;
		rateOfDepreciation = 0.0;
		numOfUsedcar++;
	}
	
	public UsedCar(String eid, double eprice, int eyear, double ecommission, double emileage, double erate) {
		super(eid, eprice, eyear, ecommission);
		this.mileage = emileage;
		this.rateOfDepreciation = erate;
		numOfUsedcar++;
	}
	
	public double computeTotal() {
		// returns the total cost of the car: baseprice - mileage*depreciation rate + commission
		double totalCost = this.baseprice - this.mileage * this.rateOfDepreciation + this.commission;
		return totalCost;
	}
	
	public String goodBusiness() {
		// returns "Good" or "Bad" based on commission
		if(this.commission > 0.04 * this.computeTotal()) return "Good";
		else return "Bad";
	}
	
	public static int getNumOfUsedcar() {
		// returns the number of instantiated UsedCar objects
		return numOfUsedcar;
	}
	
	public static double getTotalAssets() {
		// returns the total assets of all UsedCar objects
		return totalAssets;
	}
	
	public String toString() {
		// returns a string showing the values of each field
		return "Used Car" + super.toString() + String.format("%nMileage = %.2f%nTotal Cost = %.2f%nDeal = %s", this.mileage, this.computeTotal(), this.goodBusiness());
	}
	
	public void updateAssets() {
		// adds a UsedCar object's assets to the Car and UsedCar totals
		Car.addTotalAssets(this.computeTotal());
		totalAssets += this.computeTotal();
	}
	
	public double getMileage() {
		// returns the mileage of a used car
		return mileage;
	}
	
}
