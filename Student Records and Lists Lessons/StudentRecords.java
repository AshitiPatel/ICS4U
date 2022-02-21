/**
 * 
 */

/**
 * @author Ashiti
 * Date: 06 December 2021
 * Description: Class to represent object containing Academic Records
 * Method List: StudentRecords() 	-	Default constructor
 * 				String getStudentName()		-	Method to get the student name
 * 				void setStudentName(String studentName)		-	Method to set student name to a particular string
 * 				String getAddress()		-	 Method to get the address
 * 				void setAddress(String address)		-	Method to set address to a particular string
 * 				String getStudentID()	-	Method to get the Student ID
 * 				void setStudentID(String studentID)		-	Method to set Student ID to a particular string
 * 				double getAverage()		-	Method to get the average
 * 				void setAverage(double average)		-	Method to set average to a particular double value
 * 				void processRecord(String record)	-	Convert and input String into the different parts of this class
 * 				String toString()	-	Method to put whole data into a string
 * 				static void main(String[] args)		-	Self-testing main method
 */
public class StudentRecords {

	/**
	 * Instance data
	 */
	private String studentName;
	private String address;
	private String studentID;
	private double average;

	/**
	 * Default Constructor
	 */
	public StudentRecords() {

		//initialize instance variables
		this.studentName = "";
		this.address = "";
		this.studentID = "";
		this.average = 0;
	}

	/**
	 * Method to get the student name
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * Method to set student name to a particular string
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * Method to get the address
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Method to set address to a particular string
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Method to get the Student ID
	 * @return the studentID
	 */
	public String getStudentID() {
		return studentID;
	}

	/**
	 * Method to set Student ID to a particular string
	 * @param studentID the studentID to set
	 */
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	/**
	 * Method to get the average
	 * @return the average
	 */
	public double getAverage() {
		return average;
	}

	/**
	 * Method to set average to a particular double value
	 * @param average the average to set
	 */
	public void setAverage(double average) {
		this.average = average;
	}


	/**
	 * Convert and input String into the different parts of this class
	 * @param record
	 */
	public void processRecord(String record) {

		//declare an array to place the string
		String word[];
		word = record.split(",");	//splits the record into each part of the word array
		this.studentName = word[0];
		this.address = word[1];		//place each word into the right instance data
		this.studentID = word[2];
		this.average = Double.parseDouble(word[3]);

	}

	@Override
	public String toString() {
		return "StudentRecords [studentName=" + this.getStudentName() + ", address=" + this.getAddress() + ", studentID=" + this.getStudentID()
		+ ", average=" + this.getAverage() + "]";
	}

	/**
	 * Self-testing main method
	 * @param args
	 */
	public static void main(String[] args) {

		//Test all the methods in your class
		String input = "Ashit Patel,123 Daviselm Dr.,668552@pdsb,100";

		//create object based on this class
		StudentRecords sInfo = new StudentRecords(); 	//tests the constructor

		System.out.println(sInfo.toString());		//displays the empty record

		//test setters
		sInfo.setStudentName("Luke Syywalker");
		sInfo.setAddress("123 Tattion place");
		sInfo.setStudentID("123456");
		sInfo.setAverage(75.6);

		System.out.println(sInfo.toString());

		//test the process record method
		sInfo.processRecord(input);

		System.out.println(sInfo.toString());

	}

}
