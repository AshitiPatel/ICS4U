import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Ashiti
 * Date: 14/09/2021
 * Description: Converts inches to cm and vice versa
 *
 */
public class SwitchCaseEx {

	public static void main(String[] args) {

		//declare and initialize variables
		double inches = 0, cm = 0;
		char command = 0;

		//ask and keep asking if conditions not met
		do {

			//ask for command input
			command = JOptionPane.showInputDialog(null,
					"Enter 'I' to convert to inches\n'C' to convert to cm\n'X' to exit").charAt(0);

			//switch/select based on the variable
			switch(command) {

			//if case is 'I' do this
			case 'I':
			case 'i': {
				cm = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the value in cm"));
				inches = cm/2.54;
				JOptionPane.showMessageDialog(null, cm + "cm equals " + inches + "in");
				break;
			}
			//if case is 'I' do this
			case 'C':
			case 'c': {
				inches = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the value in inches"));
				cm = inches*2.54;
				JOptionPane.showMessageDialog(null, inches + "in equals " + cm + "cm");
				break;
			}
			//if case is 'I' do this
			case 'X':
			case 'x': {
				break;
			}
			//default
			default: {
				JOptionPane.showMessageDialog(null, "Enter C, I or X");
			}
			}

		} while (command != 'X' || command != 'x');

		//thank you message
		JOptionPane.showMessageDialog(null, "Thank-you for using my program");

	}

}
