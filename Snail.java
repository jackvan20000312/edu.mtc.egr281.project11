package project11;
public class Snail {
	//gets color
	//gets current Space[0-8]
	
	private static int INCREMENT_CONSTANT = 1;
	private String color;	
	private int currentSpace=0;
	
		//Main program
		// get current square number
		public int getCurrentSpace() {
			return this.currentSpace;
		}
		
		//set current square number
		private void setCurrentSpace(int newCurrentSpace) {
			this.currentSpace=newCurrentSpace;
		}
		//adds 1 to current space
		public void incrementCurrentSpace() {
			this.setCurrentSpace(this.getCurrentSpace()+INCREMENT_CONSTANT);
		}	
		
		//Gets name
		public String getColor() {
			return this.color;
		}
		
		//sets name
		public void setColor(String newColor) {
			this.color=newColor;
		}
		
	

}
