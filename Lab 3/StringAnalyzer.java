import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Ashiti
 *Date: 28/09/2021
 *Description: Analyses a phrase proided to look for the number to e's in the phrase
 *Method List: String eCalcDisp (String phrase)			//A method that finds the number of e's
 *				void main(String[] args)				//A self-testing main method
 *
 */
public class StringAnalyzer {

	/**
	 * A method that finds the number of e's
	 * @param phrase
	 * @return the number of e's
	 */
	public static String eCalcDisp (String phrase) {

		//declare the required variables
		int numOfEs = 0; 
		String locationEs = "";
		String outStatement = "";

		//loop and find num of e's and recording the location of Es
		for(int i = 0; i < phrase.length(); i++) {
			if(phrase.charAt(i) == 'e' || phrase.charAt(i) == 'E') {
				numOfEs = numOfEs + 1;
				locationEs = locationEs + ", " + i;
			}
		}
		outStatement = "The phrase '" + phrase + "' contains " + numOfEs + " e's in different locations, including and limited to" + locationEs + ".";
		return outStatement;	
	}


	/**
	 * Self testing Main Method
	 * @param args
	 */
	public static void main(String[] args) {

		//string to use
		String phrase = "Elephants eat cheese too, right?";

		//output
		JOptionPane.showMessageDialog(null, StringAnalyzer.eCalcDisp(phrase));

	}

}
