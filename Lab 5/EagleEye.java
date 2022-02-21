import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 
 */

/**
 * @author Ashiti
 * 
 *
 */
public class EagleEye extends JFrame implements ActionListener {

	/**
	 * Private instance data
	 */
	private JPanel inputPanel, outputPanel, controlPanel;
	private JTextField textInput;
	private JLabel lblInstruction, lblOutput;
	private JButton btnDisplay, btnAddToArray, btnClear;				//declare the various GUI components
	private JTextArea textOutput;
	private JScrollPane scroller;
	private Picture pic;
	private TextPicture textPic;
	private String dataArray[] = new String [10];
	private int timesAddToArrayClicked = 0;

	/**
	 * Constructor to create a window object with components
	 */
	public EagleEye() {
		super("Eagle Eye");

		setLayout(new GridLayout(5, 1));	//divide the window into 5 rows, and 1 column

		//create my panels
		inputPanel = new JPanel();
		outputPanel = new JPanel();
		controlPanel = new JPanel();

		//create the text component objects
		textInput = new JTextField("Mr. Campos is the coolest!", 30);
		lblInstruction = new JLabel("Enter your first name, last name below");
		lblOutput = new JLabel("Your name displays below");
		textOutput = new JTextArea(5, 30);

		//add the JTextArea to the scroller
		scroller = new JScrollPane(textOutput);

		//create the buttons
		btnDisplay = new JButton("Display Input");
		btnClear = new JButton("Clear");
		btnAddToArray = new JButton("Add to array");

		//create the top pic
		pic = new Picture (90, 10, 210, 50);

		//create the bottom pic (the text pic)
		textPic = new TextPicture ("You are being watched ;o)", 90, 50);
		textPic.setC(Color.MAGENTA);
		textPic.setVisible(true);

		//add my components to my window ORDER MATTERS!!
		add(pic);
		add(inputPanel);
		add(outputPanel);
		add(controlPanel);
		add(textPic);

		//add the text fields and button to the control panels
		inputPanel.add(lblInstruction);
		inputPanel.add(textInput);
		controlPanel.add(btnAddToArray);
		outputPanel.add(lblOutput);
		outputPanel.add(scroller);
		controlPanel.add(btnDisplay);
		controlPanel.add(btnClear);

		//add the buttons as listener in my JFrame
		btnDisplay.addActionListener(this);
		btnClear.addActionListener(this);
		btnAddToArray.addActionListener(this);

		//set the size, location
		setSize(400, 500);
		setLocation(100, 100);
		setResizable(false);	//make not resizable
		setVisible(true);		//display it
		setDefaultCloseOperation(EXIT_ON_CLOSE);	//close the process when X is clicked
	}

	/**
	 * Method to actually listen to events
	 */
	public void actionPerformed(ActionEvent evt) {

		//check which button was clicked
		if(evt.getSource() == btnAddToArray && timesAddToArrayClicked < 10) {

			//read the input and store it in the specific element of the array
			this.dataArray[timesAddToArrayClicked] = textInput.getText();
			timesAddToArrayClicked++;	//increase by 1

			//when array is filled
			if(timesAddToArrayClicked == 10) {
				JOptionPane.showMessageDialog(null, "Array limit reached");
			}
		}
		else if(evt.getSource() == btnDisplay) {		//if button for displaying clicked
			//display the data in array	
			for(int i = 0; i < timesAddToArrayClicked; i++) {
				textOutput.setText(textOutput.getText() + dataArray[i] + "\n");
			}	

			//changing the colors of the picture and title based on the colors that already existed
			if(pic.getC() == Color.RED && textPic.getC() == Color.MAGENTA) {
				pic.setC(Color.BLUE);
				textPic.setC(Color.CYAN);
			}
			else {
				pic.setC(Color.RED);
				textPic.setC(Color.MAGENTA);
			}
		}
		else if(evt.getSource() == btnClear) {
			textInput.setText("");		//clear input field
			textOutput.setText("");		//clear output field
			for(int i = 0; i < dataArray.length; i++) {		//reset array data
				dataArray[i] = "";
			}
			timesAddToArrayClicked = 0;		//reset the integer to 0
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//declare and create a SimpleGUI object
		EagleEye myGUI = new EagleEye();

	}

}
