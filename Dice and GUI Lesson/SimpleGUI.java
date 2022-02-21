import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
 * A simple grapjical user interface to display the picture and text picture and illustrate the use of other components
 *
 */
public class SimpleGUI extends JFrame implements ActionListener {

	/**
	 * Private instance data
	 */
	private JPanel inputPanel, outputPanel, controlPanel;
	private JTextField textInput;
	private JLabel lblInstruction;
	private JButton btnAdd, btnClear;								//declare the variour GUI components
	private JTextArea textOutput;
	private JScrollPane scroller;
	private Picture top, bottom;

	/**
	 * Constructor to create a window object with components
	 */
	public SimpleGUI() {
		super("My Simple GUI");

		setLayout(new GridLayout(5, 1));	//divid the window into 5 rows, and 1 column

		//create my panels
		inputPanel = new JPanel();
		outputPanel = new JPanel();
		controlPanel = new JPanel();

		//create the text component objects
		textInput = new JTextField("I am watching you! :O", 30);
		lblInstruction = new JLabel("This is just to output text");
		textOutput = new JTextArea(5, 30);

		//add the JTextArea to the scroller
		scroller = new JScrollPane(textOutput);

		//create the buttons
		btnAdd = new JButton("Click Me!!");
		btnClear = new JButton("Clear");

		//create the top and bottom pictures
		top = new Picture (100, 10, 100, 50);
		bottom = new Picture (150, 20, 150, 60);
		bottom.setColor(Color.MAGENTA);

		//add my components to my window ORDER MATTERS!!
		add(top);
		add(inputPanel);
		add(outputPanel);
		add(controlPanel);
		add(bottom);

		//add the text fields and button to the control panels
		inputPanel.add(lblInstruction);
		inputPanel.add(textInput);
		outputPanel.add(scroller);
		controlPanel.add(btnAdd);
		controlPanel.add(btnClear);

		//add the button as a listener in my JFrame
		btnAdd.addActionListener(this);
		btnClear.addActionListener(this);

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
		if(evt.getSource() == btnAdd) {
			String input, output;
			input = textInput.getText();
			output = textOutput.getText() + input + "\n";
			textOutput.setText(output);
		}
		else if(evt.getSource() == btnClear) {
			textInput.setText("");
			textOutput.setText("");
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//declare and create a SimpleGUI object
		SimpleGUI myGUI = new SimpleGUI();

	}

}
