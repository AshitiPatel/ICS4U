import javax.swing.JOptionPane;

/**
 *
 */

/*
 * @author Ashiti 
 * Date: 06 December 2021
 * Description: A class that represents a list of StudentRecords. It modifies and performs certain tasks (delete, change, search, print) to it according to the input
 * Method List: StudentRecordList()		- 	default constructor
 * 				boolean insert (StudentRecords record)	-	method to insert a record in the list
 *				boolean delete(StudentRecords record)	-	Method to "delete" a record from the list.
 *				boolean change (StudentRecords oldR, StudentRecords newR)	-	Method to change existing record to some other record
 *				int getSize()	-	Method to get the size
 *				String toString()	-	method to convert the list to a string
 *				static void main(String[] args)		-	Self-testing main method
 *				int linearSearch(String searchKey)	-	method that uses linear search algorithm to search for specific data based on the requirement(name)
 *				StudentRecords[] getList()	-	Method to get the list of records
 */
public class StudentRecordList {

	/**
	 * Instance data
	 */
	private StudentRecords list[];
	private int maxSize; //maximum number of records that can exist in the list
	private int size; //actual usable size at any point

	/**
	 * default constructor
	 */
	public StudentRecordList() {
		// initialize the data
		this.maxSize = 10;
		this.list = new StudentRecords [maxSize];
		this.size = 0;

	}

	/**
	 * method to insert a record in the list
	 * Checks if the size is below the maximum size
	 * if if it, increases the size by one and adds it
	 * the record to the location just below the size
	 * returns true if successful
	 */
	public boolean insert (StudentRecords record) {
		if (size < maxSize) { //if there is
			size++; //increase size
			list[size-1]= record; //place the record at size-1
			return true; //return success
		}
		return false; //no space
	}

	/**
	 * Method to "delete" a record from the list.
	 * Cheats by replacing the record to be deletes
	 * with the last record on the list
	 * then decreases the actual valid size
	 */
	public boolean delete(StudentRecords record) {
		//loop through the valid list
		for (int i = 0; i < this.getSize(); i++) {
			//check if the record is in the list
			if (this.list[i].getStudentName().equalsIgnoreCase(record.getStudentName())){
				this.list[i]= this.list[size-1]; //put the last record where the record to be deleted is found
				size--; //Decrease the valid size
				return true;
			}
		}
		return false; //record was not found
	}

	/**
	 * Method to change existing record to some other record
	 * Delete the old record 
	 * Add a new record
	 */
	public boolean change (StudentRecords oldR, StudentRecords newR) {
		//delete the old record
		if(delete(oldR)) {	//checks
			insert(newR);	//inserts the new record
			return true;
		}
		return false;	//could not delete the record
	}

	/**
	 * Method to get the size
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Method to get the list of records
	 * @return the list
	 */
	public StudentRecords[] getList() {
		return list;
	}

	/**
	 * create a toString method to convert the list to a string
	 */
	public String toString() {
		String theList = ""; //an output variable which is empty
		//loop through the valid elements of the list
		for (int i = 0; i < this.getSize(); i++) {
			//add a record to the output variable
			theList = theList + "Record" + i + ":  "+ list[i].toString() + "\n";
		}
		return theList;
	}

	/**
	 * The linear search method 
	 * Search for the student name
	 * @param searchKey
	 * @return
	 */
	public int linearSearch(String searchKey) {
		//loop to check each element
		for (int i = 0; i < size; i++)
			//checking whether the record matches the searchKey
			if(searchKey.equalsIgnoreCase(list[i].getStudentName())) {
				return i;
			}
		return -1;
	}

	/**
	 * The binary search algorithm
	 * Searches for the student name
	 * Assumes that the names are sorted in alpha
	 * @param searchKey
	 * @return
	 */
	public int binarySearch (String searchKey) {
		int low = 0;
		int high = size - 1;
		int middle;

		//while the low end of the array is below the high
		while(low <= high) {
			middle = (high + low) / 2;
			if(searchKey.equalsIgnoreCase(list[middle].getStudentName())) {
				return middle; 	//found it yayyyy!
			}
			else if (searchKey.compareToIgnoreCase(list[middle].getStudentName()) < 0) {
				high = middle - 1; //high is at middle less 1
			}
			else {
				low = middle + 1;	//low is now at middle plus 1
			}
		}
		//not found :(
		return -1;
	}

	/***
	 * Bubble sort method 
	 * Sorts name in alpha
	 */
	public void bubbleSort() {
		//loop through the array for as many elements are valid
		for(int i = 0; i < size; i++) {
			//loops to control the comparison - It leaves once sorted without comparing them
			for(int j = 0; j < size - 1; j++) {
				//compare the side by side elements and swap
				if(list[j].getStudentName().compareToIgnoreCase(list[j+1].getStudentName()) > 0) {
					//out of sequence and swap
					StudentRecords temp; //temporary student record
					//swap
					temp = list[i];
					list[j] = list[j+1];
					list[j+1] = temp;
				}//end if
			}//end j loop
		}//end i loop
	}

	/**
	 * Self-testing main method
	 * @param args
	 */
	public static void main(String[] args) {
		// create an object of my list
		StudentRecordList students  = new StudentRecordList();

		//infinite loop
		while(true) {
			char command;
			command = JOptionPane.showInputDialog(null,
					"i - insert\n" +
							"q -quit\n"    +
							"d -delete\n" + 
							"c -change\n" +
							"s -linear search\n" +
							"b -binary search\n" +
							"S -Bubble Sort\n" +
							"p -print\n", "i").charAt(0);

			if(command == 'q') {
				break; //breaks out of the while loop
			}//quit
			switch(command) {
			case'i':{//insert
				//prompt for the record
				String record = JOptionPane.showInputDialog(null, "Enter <name,address,ID,average>", "Tony Campos,123 myAdress,p0067706,75.5");
				StudentRecords sInfo = new StudentRecords();
				sInfo.processRecord(record);
				//test the insert
				if (students.insert(sInfo)) {
					JOptionPane.showMessageDialog(null, "record inserted");
				}
				else {
					JOptionPane.showMessageDialog(null, "insert failed");
				}
				break;

			}//case insert
			case'd':{
				//prompt for the record
				String record = JOptionPane.showInputDialog(null, "Enter <name,address,ID,average>", "Tony Campos,123 myAdress,p0067706,75.5");
				StudentRecords sInfo = new StudentRecords();
				sInfo.processRecord(record);
				//test the delete
				if (students.delete(sInfo)) {
					JOptionPane.showMessageDialog(null, "record deleted ");
				}
				else {
					JOptionPane.showMessageDialog(null, "Record not found");
				}
				break;
			}//case delete
			case 'c':{
				//prompt for old record to change
				String oldRecord = JOptionPane.showInputDialog(null, "Enter<name,address,ID,average>", "Tony Campos,123 myAdress,p0067706,75.5");
				StudentRecords oldInfo = new StudentRecords();
				oldInfo.processRecord(oldRecord);

				//prompt for new record to change
				String newRecord = JOptionPane.showInputDialog(null, "Enter<name,address,ID,average>", "Tony Campos,123 myAdress,p0067706,75.5");
				StudentRecords newInfo = new StudentRecords();
				newInfo.processRecord(newRecord);

				if(students.change(oldInfo, newInfo)) {
					JOptionPane.showMessageDialog(null, "Record changed");
				}
				else {
					JOptionPane.showMessageDialog(null, "Change failed");
				}
			}//case change
			case 's':{
				//ask for the name to find
				String nameToFind = JOptionPane.showInputDialog(null, "Enter name to find");
				int location = students.linearSearch(nameToFind);
				//check if it was found
				if(location >= 0) {
					JOptionPane.showMessageDialog(null, students.getList()[location].toString());
				}
				else {
					JOptionPane.showMessageDialog(null, nameToFind + "Not found!");
				}
				break;
			}//case linear search
			case 'b':{
				//ask for the name to find
				String nameToFind = JOptionPane.showInputDialog(null, "Enter name to find");
				int location = students.binarySearch(nameToFind);
				//check if it was found
				if(location >= 0) {
					JOptionPane.showMessageDialog(null, students.getList()[location].toString());
				}
				else {
					JOptionPane.showMessageDialog(null, nameToFind + "Not found!");
				}
				break;
			}//case binary search
			case 'S':{
				//sorts in alpha order
				students.bubbleSort();
				break;
			}//case bubble sort
			case 'p':{
				JOptionPane.showMessageDialog(null, students.toString());
				break;
			}//case print
			}//switch
		}//infinite while loop

	}//main method

}//class




