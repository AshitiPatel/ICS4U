/**
 * 
 */

/**
 * @author Ashii
 *
 */
public class TwoDiceGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//declare and create 2 die objects
		Die d1, d2;

		d1 = new Die();		//instantiating 2 dice
		d2 = new Die();

		int die1Value, die2Value, counter;

		counter = 0;

		while(true) {

			counter++;
			die1Value = d1.getValue();
			die2Value = d2.getValue();

			if(die1Value + die2Value == 7) {
				System.out.println("You win! You got a lucky 7!");
				System.out.println("It took you " + counter + " times.");
				break;
			}

			//roll the dice again
			d1.rollDie();
			d2.rollDie();
		}


	}

}
