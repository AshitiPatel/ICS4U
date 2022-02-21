import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Ashiti
 *         Date: 8 December 2021
 *         Description: A class to maintain a list of vehicles and their records
 *         with the help of the VehicleRecord class
 *         Method List: VehicleList() - Default constructor
 *         boolean increaseMaxSize(int reqMaxSize) - Method to increase the max
 *         size of the vehicle list to accommodate more records
 *         boolean insert (VehicleRecord recToInsert) - Method to insert a
 *         record
 *         boolean delete(VehicleRecord recToDelete) - Method to change/replace
 *         a record with some updates/new one
 *         String listing() - Method to write the list as one string
 *         int linearSearch(String searchModel) - method that uses linear search
 *         algorithm to search for the number of record based on its model
 *         int binarySearchRecursive(String searchMake, String searchModel, int
 *         low, int high) - A recursive method that uses binary search algorithm
 *         to search for the make of vehicles
 *         void insertionSort() - method that uses the insertion algorithm to
 *         sort data according to the alpha order of make and model
 *         void selectionSort () - method that implements selection sort to sort
 *         list according to the ascending order of the model year
 *         VehicleRecord[] getList() - Method to get the array of records
 *         int getSize() - Method to get the size of the list array
 *         static void main(String[] args) - Self-testing main method
 * 
 */
public class VehicleList {

	private VehicleRecord list[];
	private int maxSize;
	private int size;

	/**
	 * Default constructor
	 */
	public VehicleList() {
		// initialize the data
		this.maxSize = 10;
		this.list = new VehicleRecord[maxSize];
		this.size = 0;
	}

	/**
	 * Method to increase the max size of the vehicle list to accommodate more
	 * records
	 * 
	 * @param oriList
	 */
	public boolean increaseMaxSize(int reqMaxSize) {

		if (reqMaxSize > this.maxSize) {

			VehicleRecord tempList[] = new VehicleRecord[reqMaxSize];

			// for loop to go through the list one by one
			for (int i = 0; i < this.maxSize; i++) {
				// copy the element into the new list
				tempList[i] = this.list[i];
			}

			// store all values from new list to the old one
			this.list = tempList;
			this.maxSize = reqMaxSize;
			return true;
		}
		return false;
	}

	/**
	 * Method to insert a record
	 * 
	 * @param recToInsert
	 * @return
	 */
	public boolean insert(VehicleRecord recToInsert) {
		if (size < maxSize) { // check if a new record can be accomodated
			size++; // inc current size
			list[size - 1] = recToInsert; // add new record in the end
			return true;
		}
		return false;
	}

	/**
	 * Method to delete a record from the list
	 * 
	 * @param record
	 * @return
	 */
	public boolean delete(VehicleRecord recToDelete, char changeOrMain) {
		// use binary search method to find the location of the record
		int loc = binarySearchRecursive(recToDelete.getMake(), recToDelete.getModel(), 0, this.size);

		if (loc >= 0) {
			this.list[loc] = this.list[size - 1]; // put last record where the record to be deleted is found
			size--; // decrease the valid size
			if (changeOrMain == 'm') { // sort only if method is called from the main (and not from the change method)
				insertionSort(); // sorting the remaining data in alpha order using the insertion sort method
			}
			return true;
		}
		return false;
	}

	/**
	 * Method to change/replace a record with some updates/new one
	 * 
	 * @param oldRec
	 * @param newRec
	 * @return
	 */
	public boolean change(VehicleRecord oldRec, VehicleRecord newRec) {
		// delete old record using the pre-existing method
		if (delete(oldRec, 'c')) { // checks whether the record to be replaced/changed exists or not and deletes it
									// if it does
			insert(newRec); // inserts the new record
			insertionSort(); // sort data now (after adding the record)
			return true;
		}
		return false; // record does not exist and hence could not be replaced/changed
	}

	/**
	 * Method to write the list as one string
	 */
	public String listing() {
		String theList = ""; // output variable
		// loop through the valid elements of the list
		for (int i = 0; i < this.size; i++) {
			// add record to the output variable
			theList = theList + "Record " + (i + 1) + ": " + list[i].toString() + "\n";
		}
		return theList; // return output variable
	}

	/**
	 * A linear search method to search for the model of the vehicle
	 * 
	 * @param searchModel
	 * @return
	 */
	public int linearSearch(String searchModel) {
		// loop to check each element's model
		for (int i = 0; i < this.size; i++) {
			// checking whether the record matches the search key
			if (searchModel.equalsIgnoreCase(list[i].getModel())) {
				return i;
			}
		}
		return -1; // when record is not found
	}

	/**
	 * A recursive method that uses binary search algorithm to search for the make
	 * and model of vehicles
	 * 
	 * @param search
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	public int binarySearchRecursive(String searchMake, String searchModel, int low, int high) {

		// calculating middle
		int middle = (low + high) / 2;

		// base case (basically ensuring nothing is checked more than once or not going
		// beyond the existing limits)
		if (high < low) {
			return -1;
		}

		// recursively calling the method accordingly
		if (searchMake.compareToIgnoreCase(list[middle].getMake()) < 0) { // when present in the first half
			return binarySearchRecursive(searchMake, searchModel, low, middle - 1);
		}

		else if (searchMake.compareToIgnoreCase(list[middle].getMake()) > 0) { // when present in the second half
			return binarySearchRecursive(searchMake, searchModel, middle + 1, high);
		}

		else if (searchMake.compareToIgnoreCase(list[middle].getMake()) == 0) { // found the make!!

			// use the same algorithm to search for model
			if (searchModel.compareToIgnoreCase(list[middle].getModel()) < 0) {
				return binarySearchRecursive(searchMake, searchModel, low, middle - 1);
			} else if (searchModel.compareToIgnoreCase(list[middle].getModel()) > 0) {
				return binarySearchRecursive(searchMake, searchModel, middle + 1, high);
			} else if (searchModel.compareToIgnoreCase(list[middle].getModel()) == 0) { // return when both make and
																						// model match
				return middle;
			}
		}
		return -1;
	}

	/**
	 * A method that uses the insertion algorithm to sort data according to the
	 * alpha order of make and model
	 */
	public void insertionSort() {
		// loop for filled elements
		for (int i = 1; i < this.size; i++) {
			// assign the valuse to a temporary record
			VehicleRecord temp = list[i];
			int x = i; // to be used later when checking if the record is supposed to be up higher

			// check whether the record is supposed to be up higher
			// **********while loop updated to sort the models as well in order facilitate
			// the updated binary search method
			while ((x > 0) && ((temp.getMake().compareToIgnoreCase(list[x - 1].getMake())) < 0) ||
					((x > 0) && ((temp.getMake().compareToIgnoreCase(list[x - 1].getMake())) == 0)
							&& ((temp.getModel().compareToIgnoreCase(list[x - 1].getModel())) < 0))) {

				list[x] = list[x - 1]; // switch accordingly
				x--;
			}
			list[x] = temp; // assign accordingly; position temp
		}
	}

	/**
	 * A method that implements selection sort to sort list according to the
	 * ascending order of the model year
	 */
	public void selectionSort() {
		for (int i = this.size - 1; i > 0; i--) {
			int bigLoc = 0;
			for (int j = 1; j <= i; j++) {
				if (list[j].getYear() > list[bigLoc].getYear()) {
					bigLoc = j;
				}
			}
			VehicleRecord temp = list[i];
			list[i] = list[bigLoc];
			list[bigLoc] = temp;
		}
	}

	/**
	 * Method to get the array of records
	 * 
	 * @return the list
	 */
	public VehicleRecord[] getList() {
		return list;
	}

	/**
	 * Method to get a specific item from the list
	 * 
	 * @param loc
	 * @return
	 */
	public VehicleRecord getListItem(int loc) {
		return list[loc];
	}

	/**
	 * Method to set a specific record to the requested record
	 * 
	 * @param loc
	 * @param record
	 */
	public void setListItem(int loc, VehicleRecord record) {
		list[loc] = record;
	}

	/**
	 * Method to get the size of the list array
	 * 
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @return the maxSize
	 */
	public int getMaxSize() {
		return maxSize;
	}

	/**
	 * Method that writes all relevant data into a new file
	 * 
	 * @param newFileName
	 * @throws IOException
	 */
	public void toFile(String newFileName) throws IOException {

		// create new file
		File newFile = new File(newFileName);

		// setup writer
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFile)));

		// write max size in the first line
		writer.write(Integer.toString(maxSize));
		System.out.println("The max size is: " + maxSize);
		writer.newLine();

		// write the current size in the next line
		writer.write(Integer.toString(size));
		System.out.println("The size is: " + size);

		// loop to write each vehicle record from the list
		for (int i = 0; i < size; i++) {
			writer.newLine();
			writer.write(
					list[i].getMake() + "/" + list[i].getModel() + "/" + list[i].getYear() + "/" + list[i].getType());
		}
		writer.close();
	}

	/**
	 * Method that reads data from a file and stores it into the respective
	 * attributes
	 * 
	 * @param fileName
	 * @throws IOException
	 */
	public void readFromFile(String fileName) throws IOException {

		// setup reader for reading
		BufferedReader reader = new BufferedReader(new FileReader(fileName));

		// read the first line that contains the max size
		int tempMaxSize = Integer.parseInt(reader.readLine());

		// increase the size of the current list if needed
		if (increaseMaxSize(tempMaxSize)) {
			System.out.println("Max size increased");
		}

		// read the second line that contains the size of the array (aka the number of
		// records that exist in the list)
		this.size = Integer.parseInt(reader.readLine());

		VehicleRecord temp = new VehicleRecord();
		VehicleList tempList = new VehicleList();
		

		// loop to read the list (and convert each item from string to the respective
		// record)
		for (int i = 0; i < size; i++) {
			temp.processRecord(reader.readLine());
			list[i] = temp;
			System.out.println(
					list[i].getMake() + " " + list[i].getModel() + " " + list[i].getYear() + " " + list[i].getType());
		}
		// close the reader
		reader.close();
	}

	/**
	 * Self-testing main method
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		// create an object of my list
		VehicleList vehicles = new VehicleList();

		// infinite loop
		while (true) {
			char choice;
			choice = JOptionPane.showInputDialog(null, "i - inesrt\n" +
					"e - exit\n" +
					"d - delete\n" +
					"c - change\n" +
					"m - increase maximum size\n" +
					"s - linear search\n" +
					"b - binary search\n" +
					"I - insertion sort\n" +
					"S - selection sort\n" +
					"w - write data in new file\n" +
					"r - read data from a file\n" +
					"p - print", "i").charAt(0);

			if (choice == 'e') {
				break; // breaks out of the while loop if user chooses to quit
			} // exit

			switch (choice) {
				case 'i': { // insert
					// prompt
					String rec = JOptionPane.showInputDialog(null, "Enter <make/model/year/type>",
							"Toyota/Camry/2020/p");
					VehicleRecord vInfo = new VehicleRecord();
					vInfo.processRecord(rec);

					// testing insert method
					if (vehicles.insert(vInfo)) {
						JOptionPane.showMessageDialog(null, "record inserted");
					} 
					else {
						JOptionPane.showMessageDialog(null, "insert failed");
					}
					break;
				} // insert case
				case 'd': {
					// prompt
					String rec = JOptionPane.showInputDialog(null, "Enter <make/model/year/type>",
							"Toyota/Camry/2020/p");
					VehicleRecord vInfo = new VehicleRecord();
					vInfo.processRecord(rec);

					// testing the delete method
					if (vehicles.delete(vInfo, 'm')) {
						JOptionPane.showMessageDialog(null, "record deleted");
					} else {
						JOptionPane.showMessageDialog(null, "record not found");
					}
					break;
				} // delete case
				case 'c': {
					// prompt for old record to change
					String recOld = JOptionPane.showInputDialog(null,
							"Enter old record that needs to be changed\n<make/model/year/type>", "Toyota/Camry/2020/p");
					VehicleRecord vInfoOld = new VehicleRecord();
					vInfoOld.processRecord(recOld);

					// prompt for new record
					String recNew = JOptionPane.showInputDialog(null, "Enter new record\n<make/model/year/type>",
							"Toyota/Camry/2020/p");
					VehicleRecord vInfoNew = new VehicleRecord();
					vInfoNew.processRecord(recNew);

					// testing the change method
					if (vehicles.change(vInfoOld, vInfoNew)) {
						JOptionPane.showMessageDialog(null, "Record changed");
					} else {
						JOptionPane.showMessageDialog(null, "Change failed");
					}
					break;
				} // change case
				case 'm': {
					// prompt
					int newSizeReq = Integer.parseInt(
							JOptionPane.showInputDialog(null, "Enter the new maximum size of the list:", "20"));

					// check whether size increase is possible
					if (vehicles.increaseMaxSize(newSizeReq)) {
						JOptionPane.showMessageDialog(null, "size increased to " + newSizeReq);
					} else {
						JOptionPane.showMessageDialog(null, "Maximum size increase request failed");
					}
					break;
				} // max size increase case
				case 's': {
					// prompt
					String modelFind = JOptionPane.showInputDialog("Enter the model to find:");

					// send to linear search method and get the appropriate num
					int loc = vehicles.linearSearch(modelFind);

					// check whether it exists and display output accordingly
					if (loc > 0) {
						JOptionPane.showMessageDialog(null, vehicles.getList()[loc].toString());
					} else {
						JOptionPane.showMessageDialog(null, modelFind + "Not found!");
					}
					break;
				} // linear search case
				case 'b': {
					// prompt
					String makeToFind = JOptionPane.showInputDialog("Enter the make to find:");
					String modelToFind = JOptionPane.showInputDialog("Enter the model to find:");

					// send to binary search method and get the appropriate num
					int loc = vehicles.binarySearchRecursive(makeToFind, modelToFind, 0, vehicles.getSize());

					// check whether it exists and display output accordingly
					if (loc > 0) {
						JOptionPane.showMessageDialog(null, vehicles.getList()[loc].toString());
					} else {
						JOptionPane.showMessageDialog(null, makeToFind + " " + modelToFind + " Not found!");
					}
					break;
				} // binary search case
				case 'I': {
					// sorts in alpha order of make
					vehicles.insertionSort();
					break;
				} // case insertion sort
				case 'S': {
					// sorts in ascending order of model year
					vehicles.selectionSort();
					break;
				} // case selection sort
				case 'w': {
					String toFileName = JOptionPane.showInputDialog(null, "Enter the name of the new file:");

					// write the data into the new file using the method
					vehicles.toFile(toFileName);

					// inform the user
					JOptionPane.showMessageDialog(null, "Data stored in a new File");
					break;
				} // writing to a file case
				case 'r': {
					String fileName = JOptionPane.showInputDialog(null,
							"Enter the name of the file that contains the data:");

					System.out.println("Method called");
					// write the data into the new file using the method
					vehicles.readFromFile(fileName);

					// inform the user
					JOptionPane.showMessageDialog(null, "Data collected");
					break;
				} // reading from a case
				case 'p': {
					JOptionPane.showMessageDialog(null, vehicles.listing());
					break;
				} // print case
			}// switch
		} // infinite while loop
	}// main method
}// class
