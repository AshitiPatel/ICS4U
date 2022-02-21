import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 */

/**
 * @author Ashiti
 * Date: 28/09/2021
 * Description: A class to read and load the file data
 * Method List: String[] readingFile(String fileName) throws IOException	//a method that reads from the file 
 * 				void toNewFile(String[] phrases) throws IOException			//a method that writes the analysis into the new file
 *				void main(String[] args) throws IOException					//self-testing main method
 */
public class PhraseLoader {

	/**
	 * A method that reads from the file and stores it
	 * @param fileName
	 * @return an array of each element containing a phrase 
	 * @throws IOException
	 */
	public static String[] readingFile(String fileName) throws IOException {

		//open a file for reading
		FileReader fileRead = new FileReader(fileName);
		BufferedReader input = new BufferedReader(fileRead);

		//read the number of items in the file
		int size = Integer.parseInt(input.readLine());

		//create the required array
		String filePhrases[] = new String [size];

		//read from the file and store each phrase
		for(int i = 0; i < size; i++) {
			filePhrases[i] = input.readLine();
		}

		//close file stream
		input.close();

		return filePhrases;
	}

	/**
	 * A method that writes the analysis into the new file
	 * @param phrasesAnalyzed
	 * @throws IOException
	 */
	public static void toNewFile(String[] phrases, String fileName) throws IOException {

		//open file to Write
		PrintWriter fw = new PrintWriter (new FileWriter(fileName));

		//write the size of info array
		fw.println(phrases.length);

		//call method to write each phrase in the file
		for(int i = 0; i < phrases.length; i++) {
			fw.println(phrases[i]);
		}

		//close the file
		fw.close();
	}

	/**
	 * Self testing main method
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		//declare the output array
		String output[]; 

		//load the file into the array
		output = PhraseLoader.readingFile("Phrases.txt");
		
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
		
		//call method to load analysis in the new file
		PhraseLoader.toNewFile(output, "PhrasesLoaderTested.txt");
	}

}
