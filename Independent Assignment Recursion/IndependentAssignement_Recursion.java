import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * 
 */

/**
 * @author Ashiti
 * Date: 20 December 2021
 * Description: Using different self-created recursive methods to perform certain tasks to the user's input
 * Method List: static long factorial(long num)		-	Recursive method to calculate the factorial
 * 				static void main(String[] args)		-	Main method
 *
 */
public class IndependentAssignement_Recursion {

	/**
	 * Recursive method to calculate the factorial
	 * @param num
	 * @return
	 */
	public static long factorial(long num) {
		//if statement to detect if the number is 0 or 1 (since 1! = 1 and 0! = 1) because they are our simplest cases
		if(num <= 1) {
			return 1;
		}

		//calling the method again and again till 0/1 reached
		return num * factorial(num-1);
	} 

	/**
	 * Recursive method to calculate the reversed version of a word
	 * @param word
	 * @return
	 */
	public static String reverseWord(String word) {
		//if statement for when the string is null
		if(word.equalsIgnoreCase("")) {
			return word;
		}

		//calling method again and again till the string goes null
		return reverseWord(word.substring(1)) + word.charAt(0);
	}

	/**
	 * Recursive method that returns the fibonacci number at a particular place
	 * @param num
	 * @return
	 */
	public static int fibonacci(int num) {

		//if statement for when place is 0 or 1
		if(num <= 1) {
			return num;
		}

		//for when the place of the number in the fibonacci series is higher than 1
		return (fibonacci(num - 1)+fibonacci(num - 2));
	}

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {

		//change button text
		UIManager.put("OptionPane.yesButtonText", "Factorials");
		UIManager.put("OptionPane.noButtonText", "Reverse Word");
		UIManager.put("OptionPane.cancelButtonText", "Fibonacci Sequence");

		//ask the user for what they wish to test
		int userInput = JOptionPane.showConfirmDialog(null, "Welcome to my All-In-One Program!\nSelect an algorithm option", null, JOptionPane.YES_NO_CANCEL_OPTION);

		//loop to keep asking and repeating until the user chooses to stop
		while(true) {

			//change text back to cancel for the input dialogue boxes
			UIManager.put("OptionPane.cancelButtonText", "Cancel");

			/*
			 * Recursive factorial method testing
			 */
			if(userInput == 0) {
				//declare variables for input and output
				long inputLong, outputLong;

				//prompt for input
				inputLong = Long.parseLong(JOptionPane.showInputDialog("Welcome to my factorial calculator!\nEnter a non-negative number:"));

				//re prompt in case of invalid input
				while(inputLong < 0) {
					inputLong = Long.parseLong(JOptionPane.showInputDialog("INVALID INPUT\nEnter a non-negative number:"));
				}

				//call method to get output
				outputLong = factorial(inputLong);

				//display
				JOptionPane.showMessageDialog(null, inputLong + "! = " + outputLong);

				//change button text by

			}//factorial section

			/*
			 * Recursive reverse word method testing
			 */
			else if (userInput == 1) {
				//declare variables for input
				String inputString, outputString;

				//prompt for input
				inputString = JOptionPane.showInputDialog("Welcome to my Reverse Word/Phrase calculator!\nEnter a word/phrase:");

				//output
				outputString = reverseWord(inputString);

				//display
				JOptionPane.showMessageDialog(null, inputString + " reversed is " + outputString);

			}//reverse word section

			/**
			 * Recursive fibonacci method testing
			 */
			else if(userInput == 2) {
				//declare variables for input and output
				int inputInt, outputInt;

				//prompt for input
				inputInt = Integer.parseInt(JOptionPane.showInputDialog("Welcome to my fibonacci sequence calculator!\nEnter a non-negative number:"));

				//re prompt in case of invalid input
				while(inputInt < 0) {
					inputInt = Integer.parseInt(JOptionPane.showInputDialog("INVALID INPUT\nEnter a non-negative number:"));
				}

				int count = 0;	//variable for counting the number of fibonacci numbers
				String displayString = "The Fibonacci sequence upto " + inputInt + " consists of ";		//string for display
				outputInt = fibonacci(count);	//calculate the first fibonacci number

				//loop to keep calling the recursive method till the limit is reached
				while(outputInt <= inputInt) {
					displayString = displayString + outputInt + ", ";
					count++;
					outputInt = fibonacci(count);
				}

				//display the sequence
				JOptionPane.showMessageDialog(null, displayString);

			}//fibonacci section

			else {
				break; //exit while loop 
			}//else statement 

			//change button text for the userInput dialog
			UIManager.put("OptionPane.cancelButtonText", "Fibonacci Sequence");

			//prompt for algorithm selection again 
			userInput = JOptionPane.showConfirmDialog(null, "Select an algorithm option", null, JOptionPane.YES_NO_CANCEL_OPTION);

		}//main while loop

		//greetings
		JOptionPane.showMessageDialog(null, "Thanks for using my program!");

	}//main method

}//class
