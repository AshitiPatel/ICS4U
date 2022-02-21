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
public class TriangleAreaLoop {
	
	/**
	 * Method to get area
	 * @param width
	 * @return
	 */
	public static int getArea(int width) {
		
		int area = 0;	//variable for area
		
		//loop to add all of the pixels
		for(int i = width; i >= 0; i--) {
			area += i;
		}
		
		return area;
		
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
