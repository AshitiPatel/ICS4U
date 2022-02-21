import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Ashiti
 * Date: 16/09/2021
 * Description: calculating the final velocity of a freely falling body
 * Method List: 
 *				static double calc(double h, double i)	//method to perform calculation
 *				static double convert(double finalV)	//method to convert m/s to km/h
 *				static void main(String[] args)		//main method
 *
 */
public class Question1 {

	/*
	 * Method to perform calculation
	 */
	public static double calc(double h, double i) {
		
		//calculate and return
		double vF = Math.sqrt((i*i) + (2*9.8*h));
		return vF;
		
	}
	
	/*
	 * Method that converts m/s to km/h
	 */
	public static double convert(double finalV) {
		
		//convert and return
		return finalV*3.6;
		
	}
	
	/*
	 * Main Method
	 */
	public static void main(String[] args) {
		
		//declare the required variables
		double height, initialV, finalV;
		int userInput = 0;
		
		//welcome message
		JOptionPane.showMessageDialog(null, "Welcome! This program is designed to calculate the final velocity for you.");
		
		
		while(userInput == 0) {
		//input
		height = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the height in meters:"));
		initialV = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the initial velocity in m/s:"));
		
		//call method and calculate
		finalV = Question1.calc(height, initialV);
		
		//***display result in both units
		JOptionPane.showMessageDialog(null, "The final velovity of the freely falling body is " + finalV + "m/s OR " + Question1.convert(finalV) + "km/hr.");
		
		//ask if user wants to continue
		userInput = JOptionPane.showConfirmDialog(null, "Do you want to calculate again?", "Again?", JOptionPane.YES_NO_OPTION);
		
		}
		
		//gratitude message for the user
		JOptionPane.showMessageDialog(null, "Thank you for using my program!\nI hope it was useful.");
		
		
		
		
		
		
		
		

	}

}
