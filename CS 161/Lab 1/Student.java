import java.io.*;

public class Student {

	private String name;
	private char grade;
	private double average;
	private int[] scores;
	
	public Student() {
		name = "";
		grade = 'F';
		average = 0.0;
		scores = new int[5];
	}
	public Student(String n, int[] s) {
		name = n;
		scores = s;
	}
	
	public String getName() {
		return name;
	}
	public char getGrade() {
		return grade;
	}
	public double getAverage() {
		return average;
	}
	public int[] getScores() {
		return scores;
	}
	
	public void setName(String n) {
		name = n;
	}
	public void setGrade(char g) {
		grade = g;
	}
	public void setAverage(double avg) {
		average = avg;
	}
	public void setScores(int[] s) {
		scores = s;
	}
	
	public void calculateAverage() {
		double total = 0;
		for(int i = 0; i < scores.length; i++) {
			total += scores[i];
		}
		total /= scores.length;
		average = total;
	}
	
	public void calculateGrade() {
		if(average <= 59) {
			grade = 'F';
		}
		else if(average <= 69) {
			grade = 'D';
		}
		else if(average <= 79) {
			grade = 'C';
		}
		else if(average <= 89) {
			grade = 'B';
		}
		else if(average <= 100) {
			grade = 'A';
		}
		// there is no letter grade for a number greater than 100
	}
	
	public void generateOutput(File file) throws IOException {
		String returnString = "";
		returnString += this.getName() + "\t\t";
		for(int i = 0; i < scores.length; i++) {
			returnString += scores[i] + "\t\t";
		}
		this.calculateAverage();
		this.calculateGrade();
		returnString += this.getAverage() + "\t\t";
		returnString += this.getGrade() + "\n";
		
		FileWriter fw = new FileWriter(file, true);
		fw.write(returnString);
		fw.close();
	}
}
