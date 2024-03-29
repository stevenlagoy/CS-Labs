
public class CarTest {

	public static void main(String[] args) {
		
		Car[] carInventory = {
				new NewCar("N2312", 18000, 2006, 2000, 3000, 2000),
				new UsedCar("U3425", 16000, 2003, 400, 40000, 0.15),
				new NewCar("N6467", 43000, 2006, 4000, 6000, 3000),
				new UsedCar("U2347", 8000, 1998, 700, 12000, 0.1),
				new NewCar("N0864", 24000, 2007, 1200, 2500, 0),
				new UsedCar("U4739", 18000, 2005, 2400, 12000, 0.2),
		};
		
		// update the inventory to add each car's assets
		for(Car car : carInventory) {
			car.updateAssets();
		}
		
		// print the dealer assets information
		System.out.println("Total Assets of Dealer = " + Car.totalAssets + "\n");
		
		System.out.println("Total Assets of NewCar = " + NewCar.getTotalAssets());
		System.out.printf("Average NewCar price = %.3f%n%n", NewCar.getTotalAssets() / NewCar.getNumOfNewcar());
		
		System.out.println("Total Assets of UsedCar = " + UsedCar.getTotalAssets());
		System.out.printf("Average UsedCar price = %.3f%n%n", UsedCar.getTotalAssets() / UsedCar.getNumOfUsedcar());
		
		// print the inventory details
		for(Car car : carInventory) {
			System.out.println(car.toString() + "\n");
		}
	}
	
}
