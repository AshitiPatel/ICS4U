import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * 
 */

/**
 * @author Ashiti
 * Date: 27/09/2021
 * Description: The user interface
 *
 */
public class PersonalInfoUI {

	/**
	 * @param args 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		String input[], output;
		String fileName = null;

		try {
			fileName = JOptionPane.showInputDialog(null, "Enter a file name", "PersonalInfoFile.txt");

			input = Loader.loadFile(fileName);	//load file into input

			String text = "";

			for(int i = 0; i < input.length; i++) {
				output = PersonalInfoProcessor.processInformation(input[i]);
				text += output + "\n\n";     //same as: text = text + output + "\n\n";
			}

			//set up a text area to display the text
			JTextArea displayArea = new JTextArea();
			displayArea.setText(text);
			displayArea.setEditable(false);
			JOptionPane.showMessageDialog(null, displayArea);

		} 
		catch(FileNotFoundException error) {
			JOptionPane.showMessageDialog(null, fileName + " cannot be found!");
		}
		catch(NumberFormatException error) {
			JOptionPane.showMessageDialog(null, fileName + " is corrupted!");
		}
		catch(Exception error) {
			JOptionPane.showMessageDialog(null,"Unknown Error!");
		}

	}

}
