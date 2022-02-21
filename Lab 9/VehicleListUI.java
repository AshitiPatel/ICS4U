import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 
 */

/**
 * @author Ashiti
 *         Date: 16 January 2022
 *         Description: User Interface class that manages user experience and
 *         coordination between functions, methods, data, and user input
 *         Method List: VehicleListUI() - Default Constructor
 *         void actionPerformed(ActionEvent e) - Method that performs tasks
 *         according to the buttons clicked
 *         static void main(String[] args) - Main method
 */
public class VehicleListUI extends JFrame implements ActionListener {

	/**
	 * Private attributes
	 */
	private JTextField textInput;
	private JTextArea textOutput;
	private JPanel inputPanel, outputPanel, controlPanel;
	private JButton btnInsert, btnExit, btnDelete, btnChange, btnIncrease, btnSearchMake, btnSortYear, btnToFile, btnLoadFromFile, btnDisplay, btnClear;
	private JLabel lblInstructions1, lblInstructions2, lblInstructions3, lblInstructions4, lblUpdates;
	private JScrollPane scroller;
	private VehicleList vehicles = new VehicleList();
	private VehicleRecord temp1 = new VehicleRecord();
	private VehicleRecord temp2 = new VehicleRecord();
	private int timesChangeClicked = 0;
	private ImagePicture carPic;
	private TextPicture titleTextPic;

	/**
	 * Default Constructor
	 */
	public VehicleListUI() {
		super("Vehicle List UI");

		setLayout(new GridLayout(5, 1)); // layout for my frame
		inputPanel = new JPanel(); // subpanels for different areas
		outputPanel = new JPanel();
		controlPanel = new JPanel();

		// create text components
		titleTextPic = new TextPicture("Vehicles Record Tracker", 115, 70);
		titleTextPic.setC(Color.BLUE);
		textInput = new JTextField("Toyota/Camry/2020/p", 37);
		lblInstructions1 = new JLabel("Enter vehicle record <make/model/year/type>");
		lblInstructions2 = new JLabel("OR <make/model> for search");
		lblInstructions3 = new JLabel("OR <year> for Sorting");
		lblInstructions4 = new JLabel("OR <file name> for file related operations");
		lblUpdates = new JLabel("");
		textOutput = new JTextArea(5, 37);
		textOutput.setEditable(false);
		scroller = new JScrollPane(textOutput); // scroller for the text area

		// create buttons and labels
		btnInsert = new JButton("Insert");
		btnExit = new JButton("Exit");
		btnDelete = new JButton("Delete");
		btnChange = new JButton("Change");
		btnIncrease = new JButton("Inc. max size");
		btnSearchMake = new JButton("Make+Model Search");
		btnSortYear = new JButton("Model Year Sort");
		btnToFile = new JButton("Save in a File");
		btnLoadFromFile = new JButton("Load from File");
		btnDisplay = new JButton("Display");
		btnClear = new JButton("Clear");

		// setup image picture
		carPic = new ImagePicture(new ImageIcon("car.jpg"), 95, 0);

		// add components to the frame
		add(titleTextPic);
		add(inputPanel);
		add(outputPanel);
		add(controlPanel);
		add(carPic);

		// add components to panels
		inputPanel.add(lblInstructions1);
		inputPanel.add(lblInstructions2);
		inputPanel.add(lblInstructions3);
		inputPanel.add(lblInstructions4);
		inputPanel.add(textInput);
		inputPanel.add(lblUpdates);
		outputPanel.add(scroller);
		controlPanel.add(btnInsert);
		controlPanel.add(btnDisplay);
		controlPanel.add(btnChange);
		controlPanel.add(btnDelete);
		controlPanel.add(btnIncrease);
		controlPanel.add(btnSearchMake);
		controlPanel.add(btnSortYear);
		controlPanel.add(btnToFile);
		controlPanel.add(btnLoadFromFile);
		controlPanel.add(btnClear);
		controlPanel.add(btnExit);

		// add buttons as listeners
		btnInsert.addActionListener(this);
		btnExit.addActionListener(this);
		btnDelete.addActionListener(this);
		btnChange.addActionListener(this);
		btnIncrease.addActionListener(this);
		btnSearchMake.addActionListener(this);
		btnSortYear.addActionListener(this);
		btnToFile.addActionListener(this);
		btnLoadFromFile.addActionListener(this);
		btnDisplay.addActionListener(this);
		btnClear.addActionListener(this);

		// set size of frame
		setSize(470, 690);
		setResizable(false);
		setVisible(true);
		setLocation(20, 20);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	/**
	 * Method that performs tasks according to the buttons clicked
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnInsert) {

			// create temporary record to process and store the input
			VehicleRecord temp = new VehicleRecord();
			temp.processRecord(textInput.getText());// process

			// check if inserting record is possible
			if (vehicles.insert(temp) == false) {
				lblUpdates.setText("Max Size Reached!!\nIncrease the max size");
			}
		} // insert button
		else if (e.getSource() == btnDisplay) {
			// sort by aplha order of make
			vehicles.insertionSort();

			// process the list and display
			textOutput.setText(vehicles.listing());
		} // display buttton
		else if (e.getSource() == btnChange) {
			// when clicked for the first time
			if (timesChangeClicked == 0) {
				temp1.processRecord(textInput.getText());// process input

				// prompt for the
				lblUpdates.setText("Enter new record and click \'change\' again or \'clear\' to reset");

				timesChangeClicked++;// increase for next time
			}
			// when clicked second time
			else {
				temp2.processRecord(textInput.getText());// process input

				// check whether record can be changed and display accordingly
				if (vehicles.change(temp1, temp2)) {
					lblUpdates.setText("Record Changed Successfully. Click \'Display\' to check");
				} else {
					lblUpdates.setText("Record Change Failed");
				}
				timesChangeClicked = 0;// revert back for normal restart
			}
		} // change button
		else if (e.getSource() == btnIncrease) {
			int newSizeReq = Integer.parseInt(textInput.getText());

			// check whether size increase is possible
			if (vehicles.increaseMaxSize(newSizeReq)) {
				lblUpdates.setText("Max Size increased to " + newSizeReq);
			} else {
				lblUpdates.setText("Maximum size increase request failed");
			}
		} // increase max size button
		else if (e.getSource() == btnDelete) {
			temp1.processRecord(textInput.getText());

			// attempt deletion and display appropriate update
			if (vehicles.delete(temp1, 'm')) {
				lblUpdates.setText("Record deleted. Click \'Display\' to check");
			} else {
				lblUpdates.setText("Record not found");
			}
		} // delete record button
		else if (e.getSource() == btnSearchMake) {
			// read and split
			String combined[] = textInput.getText().split("/");

			// send to binary search method and get the appropriate num
			int loc = vehicles.binarySearchRecursive(combined[0], combined[1], 0, vehicles.getSize());

			// check whether it exists and display output accordingly
			if (loc > 0) {
				lblUpdates.setText("Record Found");
				textOutput.setText(vehicles.getList()[loc].toString());
			} else {
				lblUpdates.setText(combined[0] + " " + combined[1] + " Not found!");
			}
		} // using binary search to search for both make and model
		else if (e.getSource() == btnSortYear) {
			// sorts in ascending order of model year
			vehicles.selectionSort();

			// display
			lblUpdates.setText("Data sorted in ascending order of Model Year. Click \'Display\' to check");
		} // using linear search to sort data in ascending order of model year
		else if (e.getSource() == btnToFile) {
			String toFileName = textInput.getText();
			try {
				vehicles.toFile(toFileName);
				lblUpdates.setText("Data of records saved to a file named " + toFileName);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} // saving data in a new file
		else if (e.getSource() == btnLoadFromFile) {
			String fileName = textInput.getText();

			// read using method
			try {
				vehicles.readFromFile(fileName);
				lblUpdates.setText("Data received from file named " + fileName + ". Click \'Display\' to check");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} // reading data from a new file
		else if (e.getSource() == btnClear) {
			// revert times changed button clicks
			timesChangeClicked = 0;

			// clear the array
			VehicleList clearAssist = new VehicleList();
			vehicles = clearAssist;

			// clear output area
			textOutput.setText("");

			// reset input area
			textInput.setText("Toyota/Camry/2020/p");

			// display update
			lblUpdates.setText("Reset Complete");
		}//clear everything/ reset
		else if(e.getSource() == btnExit) {
			System.exit(0);
		}//exit system
	}//action performed method

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {

		VehicleListUI frameUI = new VehicleListUI();

	}

}
