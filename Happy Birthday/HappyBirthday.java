import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Ashiti
 *
 */
public class HappyBirthday {

	/*
	 * Method that says happy birthday
	 */
	public static void sayHappy() {
		JOptionPane.showMessageDialog(null, "Happy Birthday to you!");
	}

	/*
	 * Method that wishes along with the name
	 */
	public static void greeting(String name) {
		JOptionPane.showMessageDialog(null, "Happy Birthday dear " + name);
	}

	/*
	 * Main method
	 */
	public static void main(String[] args) {

		//a welcome message
		JOptionPane.showMessageDialog(null, "Hello! Welcome to my program.");

		//ask the user for a name
		String name = JOptionPane.showInputDialog(null, "Please enter a name:");

		sayHappy();
		sayHappy();
		greeting(name);
		sayHappy();

	}

}

