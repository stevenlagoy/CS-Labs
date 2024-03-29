import java.util.Scanner;
import java.io.*;

public class Lab1ADriver {
	
	public static void main(String [] args) throws IOException {
				
		File data = new File("rectangleData.txt");
		Scanner fileReader = new Scanner(data);
		
		int numRectangles = Integer.parseInt(fileReader.nextLine());
		
		Rectangle[] rectangles = new Rectangle[numRectangles];
				
		for(int i = 0; i < numRectangles; i++) {
			rectangles[i] = new Rectangle(fileReader.nextInt(), fileReader.nextInt(), fileReader.next().equals("filled"));
			System.out.println(rectangles[i].toString());
		}
		
		fileReader.close();
	}
	
}