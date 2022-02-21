import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Ashiti
 * Date: 7 December 2021
 * Description: A class that records, processes and keeps track of the vehicle and its properties
 * Method List: VehicleRecord()		-	Default constructor
 * 				VehicleRecord(String record)	-	Overloaded constructor
 * 				String getMake()	-	method to get make
 * 				String getModel()	-	Method to get model
 * 				int getYear()	-	Method to get year
 * 				char getType()	-	Method to get type
 * 				String toString()	-	Method to convert the data into a presentable string
 * 				void processRecord(String record)	-	Method to store the records in the respective attributes
 * 				static void main(String[] args)		-	Self-testing main method
 *
 */
public class VehicleRecord {

	//attributes
	private String make, model;
	private int year;
	private char type;

	/**
	 * Default constructor
	 */
	public VehicleRecord() {

		this.make = "";
		this.model = "";
		this.year = 0;
		//this.type = null;	
	}

	/**
	 * Overloaded constructor
	 */
	public VehicleRecord(String record) {
		processRecord(record);
	}

	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @return the type
	 */
	public char getType() {
		return type;
	}

	/**
	 * Method to convert the data into a presentable string
	 * @param record
	 * @return
	 */
	public String toString() {

		//declare another variable for final record
		String finalRecord = this.make + " " + this.model + " " + this.year + " ";

		//if statements to convert the chars to string variables and add the respective one 
		if(this.type == 'v') {
			finalRecord+= "Van";
		}
		else if(this.type == 'p') {
			finalRecord += "Passenger";
		}
		else if(this.type == 's') {
			finalRecord += "SUV";
		}
		else if(this.type == 't') {
			finalRecord += "Truck";
		}
		else {
			finalRecord += "Unknown";
		}

		return finalRecord;	
	}

	/**
	 * Method to store the records in the respective attributes
	 * @param record
	 */
	public void processRecord(String record) {

		//declare an array to place the string
		String word[];
		word = record.split("/");
		this.make = word[0];
		this.model = word[1];
		this.year = Integer.parseInt(word[2]);
		this.type = word[3].charAt(0);
	}

	/**
	 * Self-testing main method
	 * @param args
	 */
	public static void main(String[] args) {

		String input = JOptionPane.showInputDialog(null, "Enter input:","Toyota/Camry/2020/p");

		//create object
		VehicleRecord vInfo = new VehicleRecord();

		vInfo.processRecord(input);		//test process record

		System.out.println("Make:" + vInfo.getMake());
		System.out.println("Model:" + vInfo.getModel());
		System.out.println("Year:" + vInfo.getYear());
		System.out.println("Type:" + vInfo.getType());

		System.out.println(vInfo.toString());	//test to string

		//create object from overloaded constructor
		VehicleRecord vInfo2 = new VehicleRecord("Tesla/Gen-z special/2048/a"); 
		System.out.println(vInfo2.toString());



	}

}
