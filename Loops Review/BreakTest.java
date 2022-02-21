import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Ashiti
 * Date: 14/09/2021
 * An example of a for loop using break
 *
 */
public class BreakTest {

	public static void main(String[] args) {

		//declare and initialize string for output
		String output = "";

		//for loop
		for(int i = 0; i <= 10; i++) {

			//break out of the loop when i reaches 5
			if (i == 5) {
				break;
			}

			//add integer to output
			output = output + i + "\n";

		}

		//display output
		JOptionPane.showMessageDialog(null, output);

	}

}
