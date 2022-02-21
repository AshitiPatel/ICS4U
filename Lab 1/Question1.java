import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Ashiti
 *Date: 15/09/2021
 *Description: A program that displays a Christmas song using methods
 */
public class Question1 {

	/*
	 * a method that wishes merry christmas
	 */
	public static void sayMerry(String name) {

		//a loop for repeating the same line thrice
		for(int i=0; i < 3; i++) {
			System.out.println("We wish " + name + " a merry Christmas");
		}

		System.out.println("And a happy New Year!");
	}

	/*
	 * A method for the glad tidings block
	 */
	public static void sayGladTidings(String name) {

		//displaying the lines 
		System.out.println("Glad tidings we bring");
		System.out.println("To " + name + " and their kin;");
		System.out.println("Glad tidings for Christmas");
		System.out.println("And a happy New Year!");
	}

	/*
	 * A method that displays the figgy pudding block
	 */
	public static void sayFiggyPudding() {

		//a loop for repeating the same line thrice
		for(int i=0; i < 3; i++) {
			System.out.println("We want some figgy pudding");
		}

		System.out.println("Please bring it right here!");

	}

	/*
	 * Main method
	 */
	public static void main(String[] args) {

		//a welcome message
		JOptionPane.showMessageDialog(null, "Hello! Welcome to my christmas program.");

		//ask the user for a name
		String name = JOptionPane.showInputDialog(null, "Please enter a name:");

		//using methods for displaying the song
		sayMerry(name);
		sayGladTidings(name);
		sayFiggyPudding();
		sayGladTidings(name);
		sayFiggyPudding();
		sayGladTidings(name);
		sayMerry(name);
		sayGladTidings(name);

	}

}
