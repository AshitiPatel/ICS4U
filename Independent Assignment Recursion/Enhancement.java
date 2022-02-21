import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Ashiti
 * Date: 27 December 2021
 * Description: Using a combination of methods to represent recursion on a JFrame
 * Method List: static int position(int initialPos, int side, char xOrY)	-	A method that calculates the position of an image
 * 				static int dimensions(int wOrL)		-	A method that calculates the width or length of an image
 * 				static Picture[] recursiveCalcPics (Picture pics[])		-	A recursive method to create and increase the number of elements in the picture class following a specific requirement
 * 				static void main(String[] args)		-	Main method
 *
 */
public class Enhancement {

	/**
	 * A method that calculates the position of an image
	 * @param initialPos
	 * @param width
	 * @return
	 */
	public static int position(int initialPos, int side, char xOrY) {
	
		if(initialPos >= 405 && xOrY == 'x') {
			return 405;
		}
		else if(initialPos >= 330 && xOrY == 'y') {
			return 330;
		}

		//keep increasing the xpos by 7.5% of width
		return ((int)(Math.ceil((0.075*side)+initialPos)));
	}
	
	/**
	 * A method that calculates the width or length of an image
	 * @param wOrL
	 * @return
	 */
	public static int dimensions(int wOrL) {

		//technically we wouldn't really need this if statement because the coordinates themselves would stop when the side can no longer be less than 10px but just putting it in to show that i know and that i am aiming for no side less than 10px
		if(wOrL <= 10) {
			return 10;
		}

		//keep increasing the xpos by 7.5% of width
		return (int) (Math.ceil(wOrL - (0.15*wOrL)));

	}

	/**
	 * A recursive method to create and increase the number of elements in the picture class following a specific requirement
	 * @param pics
	 * @return
	 */
	public static Picture[] recursiveCalcPics (Picture pics[]) {
		
		//base case
		if(pics[pics.length - 1].getxPos() >= 405) {
			return pics;
		}

		//create temporary array of pictures /used to increase the size of the original pic array
		Picture tempPics[] = new Picture[pics.length + 1];

		//loop to copy each element of main pic array into the temporary array
		for(int i = 0; i < pics.length; i++) {
			tempPics[i] = pics[i];
		}
		
		//passing the temporary array to the main pics array
		pics = tempPics;

		//creating a specific picture for the last element of the array
		pics[pics.length - 1] = new Picture(position(pics[pics.length - 2].getxPos(), pics[pics.length - 2].getMyWidth(), 'x'), position(pics[pics.length - 2].getyPos(), pics[pics.length - 2].getMyHeight(), 'y'), dimensions(pics[pics.length - 2].getMyWidth()), dimensions(pics[pics.length - 2].getMyHeight()));

		//re-calling the method till the base case is reached
		return recursiveCalcPics(pics);
	}

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {

		//Create a JFrame
		JFrame frame = new JFrame("Recursion Visual Demo");

		//create an object for picture
		Picture pics[] = new Picture[1];
		pics[0] = new Picture(10, 10, 780,610);		
		frame.setSize(820, 670);	//set frame size

		//calling the recursive method and assigning the newly created array of pictures
		pics = recursiveCalcPics(pics);

		//add pics to frame
		for(int i = 0; i < pics.length; i++) {
			frame.add(pics[i]);
			frame.setVisible(true);
		}//for loop
	}//main method
}//class
