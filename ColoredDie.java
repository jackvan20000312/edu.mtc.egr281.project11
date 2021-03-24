package project11;

import java.util.Random;

public class ColoredDie {	
		public static final int DEFAULT_NUMBER_OF_COLORS=6;
		private String color;
		private String [] colorOptions = {" Orange ", "   Blue ", "   Pink ", "  Green ", " Yellow ", "    Red "};
		private Random random;
		private int numberOfColors;
		
		public ColoredDie() {
			this.random = new Random();
			this.setNumberOfOptions(ColoredDie.DEFAULT_NUMBER_OF_COLORS);
			this.setColor(this.roll());
			
		}
		public String getColor() {
			return this.color;
		}
		private void setColor(String newColor) {
			this.color=newColor;
		}
		
		public String roll() {
			//sets color, uses array,  puts random number in.
			this.setColor(colorOptions[this.random.nextInt(this.getNumberOfColors())]);
			return this.getColor();
		}
		
		//Extras...
		public int getNumberOfColors() {
			return this.numberOfColors;
		}
		private void setNumberOfOptions(int newNumberOfColors) {
			this.numberOfColors = newNumberOfColors;
		}

}
