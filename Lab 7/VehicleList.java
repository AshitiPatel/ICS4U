import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Ashiti
 * Date: 8 December 2021
 * Description: A class to maintain a list of vehicles and their records with the help of the VehicleRecord class
 * Method List: VehicleList() 	-	Default constructor
 * 				boolean increaseMaxSize(int reqMaxSize)		-	Method to increase the max size of the vehicle list to accommodate more records
 * 				boolean insert (VehicleRecord recToInsert)	-	Method to insert a record
 * 				boolean delete(VehicleRecord recToDelete)	-	Method to change/replace a record with some updates/new one
 * 				String listing()	-	Method to write the list as one string
 * 				static void main(String[] args)		-	Self-testing main method
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
		//initialize the data
		this.maxSize = 10;
		this.list = new VehicleRecord [maxSize];
		this.size = 0;
	}

	/**
	 * Method to increase the max size of the vehicle list to accommodate more records
	 * @param oriList
	 */
	public boolean increaseMaxSize(int reqMaxSize) {

		if(reqMaxSize > this.maxSize) {

			VehicleRecord tempList[] = new VehicleRecord [reqMaxSize];

			//for loop to go through the list one by one
			for(int i = 0; i < this.maxSize; i++) {
				//copy the element into the new list
				tempList[i] = this.list[i];
			}

			//store all values from new list to the old one
			this.list = tempList;
			this.maxSize = reqMaxSize;
			return true;
		}
		return false;

	}

	/**
	 * Method to insert a record
	 * @param recToInsert
	 * @return
	 */
	public boolean insert (VehicleRecord recToInsert) {
		if(size < maxSize) {
			size++;
			list[size-1] = recToInsert;
			return true;
		}
		return false;
	}

	/**
	 * Method to delete a record from the list
	 * @param record
	 * @return
	 */
	public boolean delete(VehicleRecord recToDelete) {

		//loop to go through the whole list
		for(int i = 0; i < this.size; i++) {
			//check whether the record is there in the list or not
			if(this.list[i].getModel().equalsIgnoreCase(recToDelete.getModel())) {
				this.list[i] = this.list[size-1];	//put last record where the record to be deleted is found
				size--;		//decrease the valid size
				return true;
			}
		}
		return false;
	}

	/**
	 * Method to change/replace a record with some updates/new one
	 * @param oldRec
	 * @param newRec
	 * @return
	 */
	public boolean change (VehicleRecord oldRec, VehicleRecord newRec) {

		//delete old record using the pre-existing method
		if(delete(oldRec)) {	//checks whether the record to be replaced/changed exists or not and deletes it if it does
			insert(newRec);		//inserts the new record
			return true;
		}
		return false;		//record does not exist and hence could not be replaced/changed
	}

	/**
	 * Method to write the list as one string
	 */
	public String listing() {
		String theList = "";	//output variable
		//loop through the valid elements of the list
		for(int i = 0; i < this.size; i++) {
			//add record to the output variable
			theList = theList + "Record " + (i+1) + ": " + list[i].toString() + "\n";
		}
		return theList;		//return output variable
	}

	/**
	 * Self-testing main method
	 * @param args
	 */
	public static void main(String[] args) {

		//create an object of my list
		VehicleList vehicles = new VehicleList();

		//infinite loop 
		while(true) {
			char choice;
			choice = JOptionPane.showInputDialog(null, "i - inesrt\n" + 
					"e - exit\n" + 
					"d - delete\n" + 
					"c - change\n" +
					"s - increase maximum size\n" +
					"p - print", "i").charAt(0);

			if(choice == 'e') {
				break;		//breaks out of the while loop if user chooses to quit
			}//exit

			switch(choice) {
			case 'i': {	//insert
				//prompt
				String rec = JOptionPane.showInputDialog(null, "Enter <make/model/year/type>", "Toyota/Camry/2020/p");
				VehicleRecord vInfo = new VehicleRecord();
				vInfo.processRecord(rec);

				//testing insert method
				if(vehicles.insert(vInfo)) {
					JOptionPane.showMessageDialog(null, "record inserted");
				}
				else {
					JOptionPane.showMessageDialog(null, "insert failed");
				}
				break;
			}//insert case
			case 'd': {
				//prompt
				String rec = JOptionPane.showInputDialog(null, "Enter <make/model/year/type>", "Toyota/Camry/2020/p");
				VehicleRecord vInfo = new VehicleRecord();
				vInfo.processRecord(rec);

				//testing the delete method
				if(vehicles.delete(vInfo)) {
					JOptionPane.showMessageDialog(null, "record deleted");
				}
				else {
					JOptionPane.showMessageDialog(null, "record not found");
				}
				break;
			}//delete case
			case 'c': {
				//prompt for old record to change
				String recOld = JOptionPane.showInputDialog(null, "Enter old record that needs to be changed\n<make/model/year/type>", "Toyota/Camry/2020/p");
				VehicleRecord vInfoOld = new VehicleRecord();
				vInfoOld.processRecord(recOld);

				//prompt for new record 
				String recNew = JOptionPane.showInputDialog(null, "Enter new record\n<make/model/year/type>", "Toyota/Camry/2020/p");
				VehicleRecord vInfoNew = new VehicleRecord();
				vInfoNew.processRecord(recNew);

				//testing the change method
				if(vehicles.change(vInfoOld, vInfoNew)) {
					JOptionPane.showMessageDialog(null, "Record changed");
				}
				else {
					JOptionPane.showMessageDialog(null, "Change failed");
				}	
				break;
			}//change case
			case's': {
				//prompt
				int newSizeReq = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the new maximum size of the list:", "20"));

				//check whether size increase is possible
				if(vehicles.increaseMaxSize(newSizeReq)) {
					JOptionPane.showMessageDialog(null, "size increased to " + newSizeReq);
				}
				else {
					JOptionPane.showMessageDialog(null, "Maximum size increase request failed");
				}
				break;
			}//max size increase case
			case 'p': {
				JOptionPane.showMessageDialog(null, vehicles.listing());
				break;
			}//print case
			}//switch
		}//infinite while loop
	}//main method
}//class
