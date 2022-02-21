import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Ashiti 
 * Date: 14/09/2021 
 * Example of a continue command in loop
 *
 */
public class ContinueTest {

	public static void main(String[] args) {

		// declare and initialize string for output
		String output = "";

		// for loop
		for (int i = 0; i <= 10; i++) {

			//continue the loop to the next condition
			if (i == 4 || (i == 5) || i == 6) {
				continue;
			}

			/*does the same thing - using &&
			 * if ((i >= 4) && (i <= 7)) {
				continue;
				}
			 */

			// add integer to output
			output = output + i + "\n";

		}

		// display output
		JOptionPane.showMessageDialog(null, output);

	}

}
