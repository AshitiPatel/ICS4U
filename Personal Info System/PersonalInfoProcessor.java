/**
 * 
 */

/**
 * @author Ashiti
 * Date: 17/09/2021
 * Description: Processes a String into another string that can be displayed
 * Method List: String processInformation (String myString)
 * 				String convertGender(char gender)
 * 				void main(String[] args)
 *
 */
public class PersonalInfoProcessor {

	/**
	 * Method to convert a String to another that can be displayed
	 * @param myString
	 * @return formatted string with Last name, First Name, Age and gender
	 */
	public static String processInformation (String myString) {

		//declare and initialize the required variables
		String fName = null;
		String lName = null;
		int age = 0;
		char gender = 0;

		//split the input String into its parts 
		String words[] = myString.split(" ");

		for(int i = 0; i < words.length; i++) {

			//switch based on the value of i
			switch(i) {
			case 0: {
				fName = words[0];
				break;
			}
			case 1: {
				lName = words[1];
				break;
			}
			case 2: {
				age = Integer.parseInt(words[2]);
				break;
			}
			case 3: {
				gender = words[3].charAt(0);
				break;
			}
			}
		}


		String formattedInfo = "Name:\t" + lName.concat(", ").concat(fName).concat("\n")
				+"Age:\t" + age + "\n" +
				"Gender:\t" + convertGender(gender);
		return formattedInfo;

	}

	/**
	 * Method to convert char to string for gender
	 * @param gender
	 * @return string for gender
	 */
	public static String convertGender(char gender) {

		String genderStr = ""; //string for output

		//convert the string
		switch(gender) {
		case 'f':{
			genderStr = "Female";
			break;
		}
		case 'm':{
			genderStr = "Male";
			break;
		}
		default:{
			genderStr = "Other";
		}
		}

		//return the gender string
		return genderStr;

	}

	/**
	 * Self testing main
	 * @param args
	 */
	public static void main(String[] args) {
		
		String input[] = new String [3];	//input and output arrays
		String output[] = new String [3];
		
		//specify the different records
		input[0] = "Darth Vader 50 m";
		input[1] = "Lea Skywalker 30 f";
		input[2] = "R2D2 Droid 150 x";
		
		//loop through the records and convert them
		for(int i = 0; i < input.length; i++) {
			
			output[i] = PersonalInfoProcessor.processInformation(input[i]);
			System.out.println(output[i]);
		}	

	}

}
