import java.text.DecimalFormat;

import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Ashiti
 * Date: 16/09/2021
 * Description: An application that calculates the total price of a car
 * Method List: 
 *				static double calculate (double price, double rate)		//Method that calculates the charges/tax
 *				static void main(String[] args)		//Main method
 *
 */
public class Question2 {


	/**
	 * A method that calculates and returns charges/tax
	 * @param price
	 * @param rate
	 * @return the tax and/or PDI charges
	 */
	public static double calculate (double price, double rate) {

		double chargesOrTax = (rate/100) * price;

		return chargesOrTax;

	}

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {

		//		//declare and initialize the required variables
		//		double price = 0, pdiRate = 0, hstRate = 0, totalPrice = 0, pdi = 0, hst = 0;
		//		String makeAndModel = "";
		//
		//		//welcome
		//		JOptionPane.showMessageDialog(null, "Welcome to my Total-Cost-Calculating Java Program!");
		//
		//		//ask for input
		//		makeAndModel = JOptionPane.showInputDialog("Enter the make and model of the car:");
		//		price = Double.parseDouble(JOptionPane.showInputDialog("Enter the price of the car:"));
		//		pdiRate = Double.parseDouble(JOptionPane.showInputDialog("Enter the PDI rate for the car:"));
		//		hstRate = Double.parseDouble(JOptionPane.showInputDialog("Enter the HST rate for the car:"));
		//
		//		//setup for formatting the numbers
		//		DecimalFormat twoDecimalPlaces = new DecimalFormat("#0.00"); 
		//
		//		//call method and calculate
		//		pdi = Question2.calculate(price, pdiRate);
		//		hst = Question2.calculate(price, hstRate);
		//
		//		totalPrice = price + pdi + hst;
		//
		//		//display
		//		JOptionPane.showMessageDialog(null, "Make and Model: " + makeAndModel + "\nInitial Price: " + twoDecimalPlaces.format(price) + "\nPDI charges: " + twoDecimalPlaces.format(pdi) + "\nTax: " + twoDecimalPlaces.format(hst) + "\nTotal Price: $" + twoDecimalPlaces.format(totalPrice));







		//**********************************************************************************************


		/*
		 * new structure with enhancement(Question 3)
		 */

		//welcome
		JOptionPane.showMessageDialog(null, "Welcome to my Total-Cost-Calculating Java Program!");

		//ask for times
		int times = Integer.parseInt(JOptionPane.showInputDialog("How many times do you want to calculate the total cost?"));

		//setup for formatting the numbers
		DecimalFormat twoDecimalPlaces = new DecimalFormat("#0.00");

		//declare the required arrays and variable
		String[] makeModel = new String [times];
		double[] price = new double [times];
		double[] pdiRate = new double [times];
		double[] hstRate = new double [times];
		double[] totalPrice = new double [times];
		double[] pdi = new double [times];
		double[] hst = new double [times];
		String display = "";

		//ask for input using loop
		for(int i = 0; i < makeModel.length; i++) {

			makeModel[i] = JOptionPane.showInputDialog("Enter the make and model of the car:");
			price[i] = Double.parseDouble(JOptionPane.showInputDialog("Enter the price of the car:"));
			pdiRate[i] = Double.parseDouble(JOptionPane.showInputDialog("Enter the PDI rate for the car:"));
			hstRate[i] = Double.parseDouble(JOptionPane.showInputDialog("Enter the HST rate for the car:"));

			//calculate
			pdi[i] = Question2.calculate(price[i], pdiRate[i]);
			hst[i] = Question2.calculate(price[i], hstRate[i]);
			totalPrice[i] = price[i] + pdi[i] + hst[i];

			//update the display variable
			display = display + "For Entry " + (i+1) + ":\n\nMake and Model: " + makeModel[i] + "\nInitial Price: " + twoDecimalPlaces.format(price[i]) + "\nPDI charges: " + twoDecimalPlaces.format(pdi[i]) + "\nTax: " + twoDecimalPlaces.format(hst[i]) + "\nTotal Price: $" + twoDecimalPlaces.format(totalPrice[i]) + "\n\n\n";

			//a reminder/follow up message for the user
			JOptionPane.showMessageDialog(null, "Entries completed: " + (i+1) + "\nEntries left: " + (times - (i+1)));

		}
		//display + gratitude
		JOptionPane.showMessageDialog(null, display);
		JOptionPane.showMessageDialog(null, "Thank you for using my program!\nI hope it was helpful.");


	}


}
