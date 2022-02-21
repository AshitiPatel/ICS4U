import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * 
 */

/**
 * @author Ashiti
 * Date: 26 October 2021
 * Description: A game that involves six dice and compares their values to tell how many tries it took to get the same value on all dice
 * Method List: void main(String[] args)	//main method
 *
 */
public class SixDiceGame {

	/**
	 * Main Method
	 * @param args
	 */
	public static void main(String[] args) {

		//custom button text
		UIManager.put("OptionPane.okButtonText", "Roll Dice");

		//welcome message
		JOptionPane.showMessageDialog(null, "Welcome to the Six Dice Game!");

		//button text back to normal
		UIManager.put("OptionPane.okButtonText", "OK");

		int playAgain = 0;

		//creating an array of dice
		Die dice[] = new  Die [6];
		for(int i = 0; i < dice.length; i++) {
			dice[i] = new Die();
		}

		int count = 0; 		//counter

		while(playAgain == 0) {
			
			//infinite while loop; break out when all values on the dice are equal
			while (true) {
				count++;

				//compare
				if((dice[0].compareTo(dice[1])) && (dice[0].compareTo(dice[2])) && (dice[0].compareTo(dice[3])) && (dice[0].compareTo(dice[4])) && (dice[0].compareTo(dice[5]))) {
					JOptionPane.showMessageDialog(null, "Congratulations!\nAll dice equal " + dice[0].getValue() + " after " + count + " tries.");
					break;
				}

				//loop to roll the dice
				for(int i = 0; i < dice.length; i++) { 
					dice[i].rollDie();
				}
			}

			//ask for another game
			playAgain = JOptionPane.showConfirmDialog(null, "Would you like to play again?", null, JOptionPane.YES_NO_OPTION);

			if(playAgain == 0) {

				count = 0;

				//loop to roll the dice
				for(int i = 0; i < dice.length; i++) { 
					dice[i].rollDie();
				}
			}
		}

		JOptionPane.showMessageDialog(null, "Game Over!\nI hope you had fun!");
	}
}
