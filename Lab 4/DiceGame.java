import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

/**
 * 
 */

/**
 * @author Ashiti
 * Date: 27 October 2021
 * Description: A two player Dice Game
 * Method List: void display (String output)	//A method to display the output
 * 				int winnings (int sum)		 //A method that calculates the winnings based on the sum of values on the dice
 * 				void main(String[] args)		//Main method
 */
public class DiceGame {

	/**
	 * A method to display the output
	 * @param output
	 */
	public static void display (String output) {

		//declare the required variables 
		JFrame frame;
		JTextArea text;
		JScrollPane scrolltxt;
		
		//setup JFrame
		frame=new JFrame();
		frame.setLayout(null);
		frame.setSize(250,500);
		
		//setup font
		Font font = new Font("Trebuchet MS", Font.BOLD, 12);
		
		//setup JTextArea
		text = new JTextArea();
		text.setText(output);
		text.setBounds(5,5,200,400);
		text.setBackground(Color.CYAN);
		text.setFont(font);
		text.setVisible(true);
		text.setEditable(false);
		
		//setup for the scroll bar
		scrolltxt = new JScrollPane(text);
		scrolltxt.setBounds(3,3,200,400);
		
		//add scroll bar to the JFrame
		frame.add(scrolltxt);
		frame.setVisible(true);
	}

	/**
	 * A method that calculates the winnings based on the sum of values on the dice
	 * @param sum
	 * @return points won
	 */
	public static int winnings (int sum) {

		switch (sum) {
		case 2:
			return 0;
		case 3:
			return 2;
		case 4:
			return 5;
		case 5:
			return 6;
		case 6:
			return 7;
		case 7: 
			return 10;
		case 8:
			return 11;
		case 9:
			return 13;
		case 10:
			return 15;
		case 11:
			return 17;
		case 12:
			return 20;
		default:
			return 0;
		}
	}

	/**
	 * Method List
	 * @param args
	 */
	public static void main(String[] args) {

		//declare and initialize the required variables and objects
		Die d1 = new Die();
		Die d2 = new Die();
		int player1Points = 100, player2Points = 100, sumPlayer1 = 0, sumPlayer2 = 0;
		int playAgain = 0, counter = 1;
		String output = "Round " + counter + " Data\n", player1Data = "Player 1:\n", player2Data = "Player 2:\n";

		//custon button text
		UIManager.put("OptionPane.okButtonText", "Roll Dice");

		//friendly welcome message
		JOptionPane.showMessageDialog(null, "Welcome to my Dice Game!");

		//button text back to normal
		UIManager.put("OptionPane.okButtonText", "OK");

		while(playAgain == 0) {

			//calc sum of values first player
			sumPlayer1 = d1.getValue() + d2.getValue();

			//record data for output
			player1Data = player1Data + "Dice Values Sum: " + sumPlayer1 + "\n"; 

			//roll dice for second player
			d1.rollDie();
			d2.rollDie();

			//calculate sum of values for player 2
			sumPlayer2 = d1.getValue() + d2.getValue();

			//record data for output
			player2Data = player2Data + "Dice Values Sum: " + sumPlayer2 + "\n"; 

			while((player1Points-10 > 0) && (player2Points-10 > 0)) {
				//add points to the player's total points based on the sum of values rolled by the dice
				player1Points += DiceGame.winnings(sumPlayer1);
				player2Points += DiceGame.winnings(sumPlayer2);

				//remove 10 for one roll
				player1Points -= 10;
				player2Points -= 10;

				//record data for output
				player1Data = player1Data + "Points: " + player1Points + "\n";
				player2Data = player2Data + "Points: " + player2Points + "\n";

				//add data to the output variable
				counter++;
				output = output + "\n" + player1Data + "\n" + player2Data;
				
				//add the next round's heading only if it is possible
				if((player1Points-10 > 0) && (player2Points-10 > 0)) {
					output = output + "\n---------------------------------\nRound " + counter + " Data\n";
				}

				//setup for next round
				player1Data = "Player 1:\n"; 
				player2Data = "Player 2:\n";

				//roll dice again for both players and calculate the sum of values
				//player 1
				d1.rollDie();
				d2.rollDie();
				sumPlayer1 = d1.getValue() + d2.getValue();

				//player 2
				d1.rollDie();
				d2.rollDie();
				sumPlayer2 = d1.getValue() + d2.getValue();
				
				//record data for output
				player1Data = player1Data + "Dice Values Sum: " + sumPlayer1 + "\n"; 
				player2Data = player2Data + "Dice Values Sum: " + sumPlayer2 + "\n"; 
			}

			//display according to the points
			if(player1Points > player2Points) {
				DiceGame.display("PLAYER 1 WON!!!\n\n" + output);
			}
			else if(player2Points > player1Points) {
				DiceGame.display("PLAYER 2 WON!!!\n\n" + output);
			}
			else {
				DiceGame.display("IT'S A TIE!!!\n\n" + output);
			}

			//ask for another game
			playAgain = JOptionPane.showConfirmDialog(null, "Would you like to play again?", null, JOptionPane.YES_NO_OPTION);

			//reset for another game
			if(playAgain == 0) {
				//roll dice
				d1.rollDie();
				d2.rollDie();

				//reinitialize the variables
				player1Points = player2Points = 100;
				sumPlayer1 = sumPlayer2 = 0;
			}


		}//while loop

		JOptionPane.showMessageDialog(null, "Game Over!\nI hope you enjoyed!");

	}//main method

}//class
