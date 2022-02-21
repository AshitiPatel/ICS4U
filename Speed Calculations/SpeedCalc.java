import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Ashiti
 *Date: 16/09/2021
 *Description: Calculate speed based on input of distance and time
 */
public class SpeedCalc {

	/*
	 * Method to calculate the speed
	 */
	public static double calcSpeed(double d, double t) {

		//calculate and return speed (distance/time)
		return d/t;

	}

	/*
	 * Main method
	 */
	public static void main(String[] args) {

		//		//declare the required variables
		//		double distance;
		//		double time;
		//		double speed;
		//		
		//		//prompt and store input in the respective variables
		//		distance = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the distance in metres"));
		//		time = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the time in seconds"));
		//		
		//		//calculate speed by calling the method
		//		speed = SpeedCalc.calcSpeed(distance,time);
		//		
		//		//display
		//		JOptionPane.showMessageDialog(null, "The average speed is " + speed + "m/s.");


		//ARRAYS NOW:
		//declare the required arrays
		double distance[] = new double[3];
		double time[] = new double[3];
		double speed[] = new double[3];


		//loop for asking, getting and calculating the respective elements
		for(int i = 0;  i < distance.length; i++) {

			//prompt and store input 
			distance[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the distance in metres"));
			time[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the time in seconds"));

			//calculate speed by calling the method
			speed[i] = SpeedCalc.calcSpeed(distance[i],time[i]);

			//display
			JOptionPane.showMessageDialog(null, "The average speed is " + speed[i] + "m/s.");

		}

	}

}
