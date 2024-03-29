import java.util.Scanner;
import java.io.*;

public class Lab1BDriver {
		
	public static void main(String[] args) throws IOException {
		
		File inFile = new File("Lab1B_in.txt");
		File outFile = new File("Lab1B_out.txt");
		Scanner fileReader = new Scanner(inFile);
		
		Student[] students = new Student[20];
		
		int i = 0;
		while(fileReader.hasNext()) {
			String name = fileReader.next();
			int[] scores = new int[5];
			for(int j = 0; j < 5; j++) {
				scores[j] = fileReader.nextInt();
			}
			students[i] = new Student(name, scores);
			i++;
		}
		for(int j = 0; j < 10; j++) {
			students[j].generateOutput(outFile);
		}
	fileReader.close();
	}
}
