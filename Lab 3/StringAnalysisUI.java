import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Ashiti
 * Date: 29/09/2021
 * Description: A UI program that uses the pre existing classes and their methods to output the data on the screen and load it into a file
 * Method List: void main(String[] args) throws IOException 		//main method
 *
 */
public class StringAnalysisUI {

	/**
	 * Main method
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
 
		//welcome message
		JOptionPane.showMessageDialog(null, "Welcome to my String analyzing application!");

		//input text file that contains the phrases
		String fileName = JOptionPane.showInputDialog("Please enter the name of the file that contains the phrases", "Phrases.txt");

		//pass to a method from the other class to read
		String phrases[] = PhraseLoader.readingFile(fileName);

		//declare the array for analyzed phrases and an output string
		String phrasesAnalyzed[] = new String [phrases.length];
		String output = phrases.length + "\n";
		
		//pass phrases to method from StringAnalyzer to analyze and store the results
		for(int i = 0; i < phrases.length; i++) {
			phrasesAnalyzed[i] = StringAnalyzer.eCalcDisp(phrases[i]);
			output += phrasesAnalyzed[i] + "\n";
		}

		//display
		JOptionPane.showMessageDialog(null, output);
		
		//ask for name of new file
		String newFile = JOptionPane.showInputDialog("What would you like to name the new file where you save this data?","PhrasesAnalyzed.txt");
		
		//pass to method in PhraseLoader to write to a new file
		PhraseLoader.toNewFile(phrasesAnalyzed, newFile);
		
		//gratitude
		JOptionPane.showMessageDialog(null, "Thank You for using my program!\nI hope it helped!");
		

	}

}
