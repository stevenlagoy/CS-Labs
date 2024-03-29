
public class Rectangle {
	private int numRows;
	private int numCols;
	private boolean filled;
	
	public Rectangle() {
		numRows = 1;
		numCols = 1;
		filled = false;
	}
	public Rectangle(int rows, int cols, boolean fill) {
		numRows = rows;
		numCols = cols;
		filled = fill;
	}
	
	public int getRows() {
		return numRows;
	}
	public int getCols() {
		return numCols;
	}
	public boolean getFill() {
		return filled;
	}
	
	public void setRows(int rows) {
		numRows = rows;
	}
	public void setCols(int cols) {
		numCols = cols;
	}
	public void setFilled(boolean fill) {
		filled = fill;
	}
	
	public String toString() {
		String returnBox = "";
		if(filled) {
			for(int i = 0; i < this.getRows(); i++) {
				for(int j = 0; j < this.getCols(); j++) {
					returnBox += "#";
				}
				returnBox += "\n";
			}
		}
		else {
			for(int i = 0; i < this.getRows(); i++) {
				for(int j = 0; j < this.getCols(); j++) {
					if(i == 0 || j == 0 || i == this.getRows()-1 || j == this.getCols()-1) {
						returnBox += "#";
					}
					else {
						returnBox += " ";
					}
				}
				returnBox += "\n";
			}
		}
	return returnBox;
	}
}
