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
 * 				boolean delete(VehicleRecord recToDelete)	-	Method to delete a record
 * 				boolean change (VehicleRecord oldRec, VehicleRecord newRec)		-	Method to change/replace a record with some updates/new one
 * 				String listing()	-	Method to write the list as one string
 * 				int linearSearch(String searchModel) 	-	method that uses linear search algorithm to search for the number of record based on its model
 * 				int binarySearch(String searchMake)		-	A binary search method to search for the make of the vehicle
 * 				int binarySearch(String searchMake, String searchModel, int low, int high)		-	Overloaded binary search method that uses recursive algorithm of binary search
 * 				void insertionSort()	-	method that uses the insertion algorithm to sort data according to the alpha order of make and model
 * 				void selectionSort ()	-	method that implements selection sort to sort list according to the ascending order of the model year
 * 				VehicleRecord[] getList()	-	Method to get the array of records
 * 				int getSize()	-	Method to get the size of the list array
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
		if(size < maxSize) {	//check if a new record can be accomodated
			size++;		//inc current size
			list[size-1] = recToInsert;		//add new record in the end
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
		//use binary search method to find the location of the record
		int loc = binarySearch(recToDelete.getMake());

		if(loc >= 0) {
			this.list[loc] = this.list[size-1];	//put last record where the record to be deleted is found
			size--;		//decrease the valid size
			insertionSort();//sort in alpha order
			return true;
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
			insertionSort(); 	//sort data now (after adding the record)
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
	 * A linear search method to search for the model of the vehicle
	 * @param searchModel
	 * @return
	 */
	public int linearSearch(String searchModel) {
		//loop to check each element's model
		for(int i = 0; i < this.size; i++) {
			//checking whether the record matches the search key
			if(searchModel.equalsIgnoreCase(list[i].getModel())) {
				return i;
			}
		}
		return -1; //when record is not found
	}

		/**
		 * A binary search method to search for the make of the vehicle
		 * @param searchMake
		 * @return
		 */
		public int binarySearch(String searchMake) {
			//declare and initialize the required variables
			int low = 0;
			int high = size -1;
			int middle;
	
			while(low <= high) {
				middle = (high + low) / 2; 	//find middle
	
				if(searchMake.equalsIgnoreCase(this.list[middle].getMake())) {
					return middle;	//foind it!!
				}
				else if(searchMake.compareToIgnoreCase(list[middle].getMake()) < 0) {
					high = middle - 1;	//high is 1 less than middle
				}
				else {
					low = middle + 1;	//low is 1 more than the middle
				}
			}
			//not found :-(
			return -1;
		}

	/**
	 * A recursive method that uses binary search algorithm to search for the make of vehicles
	 * @param search
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	public int binarySearch(String searchMake, String searchModel, int low, int high) {

		//calculating middle
		int middle = (low + high)/2;

		//base case (basically ensuring nothing is checked more than once or not going beyond the existing limits)
		if(high < low){
			return - 1;
		} 

		//recursively calling the method accordingly
		if (searchMake.compareToIgnoreCase(list[middle].getMake()) < 0){  //when present in the first half
			return binarySearch(searchMake, searchModel, low, middle - 1);
		}

		else if (searchMake.compareToIgnoreCase(list[middle].getMake()) > 0){	//when present in the second half
			return binarySearch(searchMake, searchModel, middle + 1, high);
		}

		else if (searchMake.compareToIgnoreCase(list[middle].getMake()) == 0){	//found the make!!

			//use the same algorithm to search for model
			if(searchModel.compareToIgnoreCase(list[middle].getModel()) < 0) {
				return binarySearch(searchMake, searchModel, low, middle - 1);
			}
			else if(searchModel.compareToIgnoreCase(list[middle].getModel()) > 0) {
				return binarySearch(searchMake, searchModel, middle + 1, high);
			}
			else if (searchModel.compareToIgnoreCase(list[middle].getModel()) == 0){	//return when both make and model match
				return middle;
			}
		}
		return -1;	
	}

	/**
	 * A method that uses the insertion algorithm to sort data according to the alpha order of make and model
	 */
	public void insertionSort() {
		//loop for filled elements
		for(int i = 1; i < this.size; i++) {
			//assign the valuse to a temporary record
			VehicleRecord temp = list[i];
			int x = i;	//to be used later when checking if the record is supposed to be up higher

			//check whether the record is supposed to be up higher
			//**********while loop updated to sort the models as well in order facilitate the updated binary search method
			while((x > 0) && ((temp.getMake().compareToIgnoreCase(list[x-1].getMake())) < 0) || 
					((x > 0) && ((temp.getMake().compareToIgnoreCase(list[x-1].getMake())) == 0) && ((temp.getModel().compareToIgnoreCase(list[x-1].getModel())) < 0))) {

				list[x] = list[x-1]; //switch accordingly
				x--;
			}
			list[x] = temp;	//assign accordingly; position temp
		}
	}

	//^^^^^^^^^^This is not a part of the main code but I was just trying to debug the previous method 
	//^^^^^^^^^^I had been trying to figure out what was wrong since 3 hours when I realized that I can't use list.length 
	//^^^^^^^^^^because the length would be the max size and it's not necessary for the whole list to be filled till the max size
	//	/**
	//	 * A method that uses the insertion algorithm to sort data according to the alpha order of make
	//	 */
	//	public void insertionSort() {
	//		for(int i = 1; i < this.size; i++) {
	//			VehicleRecord temp = list[i];
	//			System.out.println("started with " + list[i] + " and gave it to temp(so now temp is:" + temp + ")");
	//			System.out.println("temp.getMake() is '"+temp.getMake());
	//			int x = i;
	//			while((x > 0) && ((temp.getMake().compareToIgnoreCase(list[x-1].getMake())) < 0)) {
	//				System.out.println("switched '" + x + list[x] + "' to '" + x + list[x-1] + "'");
	//				list[x] = list[x-1];
	//				x--;
	//			}
	//			System.out.println("'"+ x + list[x] + "' changed to '" + temp);
	//			list[x] = temp;
	//		}
	//	}

	/**
	 * A method that implements selection sort to sort list according to the ascending order of the model year
	 */
	public void selectionSort () {
		for(int i = this.size - 1; i > 0; i--) {
			int bigLoc = 0;
			for(int j = 1; j <= i; j++) {
				if(list[j].getYear() > list[bigLoc].getYear()) {
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
	 * @return the list
	 */
	public VehicleRecord[] getList() {
		return list;
	}

	/**
	 * Method to get the size of the list array
	 * @return the size
	 */
	public int getSize() {
		return size;
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
					"m - increase maximum size\n" +
					"s - linear search\n" +
					"b - binary search\n" +
					"I - insertion sort\n" +
					"S - selection sort\n" +
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
			case'm': {
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
			case 's': {
				//prompt
				String modelFind = JOptionPane.showInputDialog("Enter the model to find:");

				//send to linear search method and get the appropriate num
				int loc = vehicles.linearSearch(modelFind);

				//check whether it exists and display output accordingly
				if (loc > 0) {
					JOptionPane.showMessageDialog(null, vehicles.getList()[loc].toString());
				}
				else {
					JOptionPane.showMessageDialog(null, modelFind + "Not found!");
				}
				break;
			}//linear search case
			//			case 'b': {
			//				//prompt
			//				String makeFind = JOptionPane.showInputDialog("Enter the make to find:");
			//
			//				//send to binary search method and get the appropriate num
			//				int loc = vehicles.binarySearch(makeFind, 0, vehicles.getSize());
			//
			//				//check whether it exists and display output accordingly
			//				if (loc > 0) {
			//					JOptionPane.showMessageDialog(null, vehicles.getList()[loc].toString());
			//				}
			//				else {
			//					JOptionPane.showMessageDialog(null, makeFind + " Not found!");
			//				}
			//				break;
			//			}//binary search case
			case 'b': {
				//prompt
				String makeToFind = JOptionPane.showInputDialog("Enter the make to find:");
				String modelToFind = JOptionPane.showInputDialog("Enter the model to find:");

				//send to binary search method and get the appropriate num
				int loc = vehicles.binarySearch(makeToFind, modelToFind,0, vehicles.getSize());

				//check whether it exists and display output accordingly
				if (loc > 0) {
					JOptionPane.showMessageDialog(null, vehicles.getList()[loc].toString());
				}
				else {
					JOptionPane.showMessageDialog(null, makeToFind + " " + modelToFind + " Not found!");
				}
				break;
			}//binary search case
			case 'I': {
				//sorts in alpha order of make
				vehicles.insertionSort();
				break;
			}//case insertion sort
			case 'S': {
				//sorts in ascending order of model year
				vehicles.selectionSort();
				break;
			}//case selection sort
			case 'p': {
				JOptionPane.showMessageDialog(null, vehicles.listing());
				break;
			}//print case
			}//switch
		}//infinite while loop
	}//main method
}//class
