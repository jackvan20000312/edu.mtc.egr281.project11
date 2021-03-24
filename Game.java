package project11;
//****************************************************************************************
//Author: Jacob Vaught       Modified: 11/10/20
//
//EGR-281  Project 11  			  Due: 11/11/20
//****************************************************************************************
//This needs more classes.



import java.util.Scanner;

public class Game {
	static ColoredDie die1 = new ColoredDie();
	static ColoredDie die2 = new ColoredDie();
	static Snail Orange = new Snail();
	static Snail Blue = new Snail();
	static Snail Pink = new Snail();
	static Snail Green = new Snail();
	static Snail Yellow = new Snail();
	static Snail Red = new Snail();

	public static void set_All_Colors() {
		Orange.setColor(" Orange ");
		Blue.setColor("   Blue ");
		Pink.setColor("   Pink ");
		Green.setColor("  Green ");
		Yellow.setColor(" Yellow ");
		Red.setColor("    Red ");
	}
	Scanner keyLogger=new Scanner(System.in);
	static String roll1 = die1.roll();
	static String roll2 = die2.roll();
	//game board
	static public String [] [] blank_game_View = { 
			{" Orange |" ,"        |" ,"        |" ,"        |" ,"        |" ,"        |" ,"        |" ,"        |" ,"        |"}, 
			{"   Blue |" ,"        |" ,"        |" ,"        |" ,"        |" ,"        |" ,"        |" ,"        |" ,"        |"},
			{"   Pink |" ,"        |" ,"        |" ,"        |" ,"        |" ,"        |" ,"        |" ,"        |" ,"        |"},
			{"  Green |" ,"        |" ,"        |" ,"        |" ,"        |" ,"        |" ,"        |" ,"        |" ,"        |"},
			{" Yellow |" ,"        |" ,"        |" ,"        |" ,"        |" ,"        |" ,"        |" ,"        |" ,"        |"},
			{"    Red |" ,"        |" ,"        |" ,"        |" ,"        |" ,"        |" ,"        |" ,"        |" ,"        |"}
			 };
	//prints the board
	public static void printBoard() {
		for(int row = 0; row < blank_game_View.length; ++row) {
		for(int column = 0; column < blank_game_View[row].length; ++column) {
		System.out.print(blank_game_View[row][column]);
		}// Ending bracket of INNER loop
		System.out. println();
		}// Ending bracket of for OUTER loop
		}// Ending bracket of method printBoard
	// update the board and uses "determine who has rolled" to simplify code in game.//BIGGEST HELPER METHOD.
	public static void update_The_Tally_And_Erase_Previous_Square( String roll) {
		Snail currentSnail = determine_who_just_rolled(roll);
		int row = 0;
		//determines row
		if (currentSnail == Orange) {
			row = 0;
		}else if(currentSnail == Blue) {
			row = 1;
		}else if(currentSnail == Pink) {
			row = 2;
		}else if(currentSnail == Green) {
			row = 3;
		}else if(currentSnail == Yellow) {
			row = 4;
		}else if(currentSnail == Red) {
			row = 5;
		}
		
		//updates the board	
		blank_game_View [row][currentSnail.getCurrentSpace()] = "        |";
		currentSnail.incrementCurrentSpace();
		blank_game_View [row][currentSnail.getCurrentSpace()]=currentSnail.getColor()+"|";
		}
	// determines who just rolled
	public static Snail determine_who_just_rolled(String roll) {
		switch(roll) {
		case" Orange ":
			return Orange;
		case"   Blue ": 
			return Blue;
		case"   Pink ": 
			return Pink;
		case"  Green ":
			return Green;
		case" Yellow ": 
			return Yellow;
		case"    Red ":
			return Red;
		default: 
			System.out.println("ERROR!");
        return Orange;
		}
	}
	//main arguments
	public static void main(String[] args) {
		int roll=0;
		Scanner keyLogger=new Scanner(System.in);
		System.out.println("Enter the color of the snail that you think will win.");
		String userWinner= keyLogger.next();
		System.out.println("Enter the color of the snail that you think will lose.");
		String userLoser= keyLogger.next();
		set_All_Colors();
		System.out.println("Start of Snail's Pace Race®");
		printBoard();
		System.out.println();
		// Start do Loop Here.
		
		do {
		++roll;
		String roll1 = die1.roll();
		String roll2 = die2.roll();
		
		update_The_Tally_And_Erase_Previous_Square(roll1);
		update_The_Tally_And_Erase_Previous_Square(roll2);
		
		System.out.println("Roll #"+roll+" - Rolled a "+roll1+" and a "+roll2);
		if (roll1==roll2) {
			System.out.println("You got Double Rolled. "+roll1+" moved 2 spaces.");
			System.out.println("--------------------------------------------");
		}else {
			System.out.println("--------------------------------------------");
			
		}
		printBoard();
		System.out.println();
		}while(Orange.getCurrentSpace()<8 && Blue.getCurrentSpace()<8 && Pink.getCurrentSpace()<8 && Green.getCurrentSpace()<8&&
		Yellow.getCurrentSpace()<8 && Red.getCurrentSpace()<8);
		
		
		// A class would be great right here, but i do not have time to finish it right now.
		String winner="ERROR";
		if (Red.getCurrentSpace()>=8) {
			winner="Red";
		}else if (Yellow.getCurrentSpace()>=8) {
			winner="Yellow";
		}else if (Green.getCurrentSpace()>=8) {
			winner="Green";
		}else if (Pink.getCurrentSpace()>=8) {
			winner="Pink";
		}else if (Blue.getCurrentSpace()>=8) {
			winner="Blue";
		}else if (Orange.getCurrentSpace()>=8) {
			winner="Orange";
		}
		if (winner.equalsIgnoreCase(userWinner)) {
			System.out.println("You are Correct! "+winner+" is the winner!");
		}else {
			System.out.println(winner+" is the winner!, and you were wrong. :(");
		}
		
		//replace x with "        |"
		
		keyLogger.close();
	}
}// closing bracket of class
