import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Ashiti
 * Date: 9 December 2021
 * Description: Calculates the rough area of a right angled triangle given its width (base) in pixels
 * Method List: 
 *
 */
public class TriangleAreaRecursive {
	
	/**
	 * Recursive method to get area
	 * @param width
	 * @return
	 */
	public static int getArea(int width) {
		//if statement to detect my simplest cases
		//width of 0 or 1 means the area is 0 or 1
		if(width <= 1) {
			return width;
		}
		return width + getArea(width - 1);
	}
	
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {

		//declare the input
		int w = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the width of the triangle"));
		
		int a = getArea(w);		//calls the method to get area
		
		//display the area
		JOptionPane.showMessageDialog(null, "The area of the triangle is " + a + " pixels");

	}

}
