import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * 
 */

/**
 * @author Ashiti
 * Simulates a moving image
 *
 */
public class GameUI extends JFrame implements ActionListener{

	/*
	 * Declare our instance variables
	 */
	private TextPicture myTitle;
	private ImagePicture myIcon;
	private JPanel drawingPanel, buttonPanel;
	private JButton btnStart, btnExit;
	private Die d;
	private Timer iconTimer;


	/**
	 * Constructor
	 */
	public GameUI() {
		super("The Game UI");
		setLayout(null); 	//set to a null layout to control the locations


		//set size and locations of our frame
		setSize(500, 700);
		setLocation(100, 10);

		//>>>>> The drawingPanel code
		drawingPanel = new JPanel();

		//set the layout and boundaries of our drawing panel
		drawingPanel.setLayout(null);
		drawingPanel.setBounds(0, 50, 500, 500);

		//add it to the JFrame
		add(drawingPanel);

		//>>>>> The buttonPAnel code
		buttonPanel = new JPanel();

		//set the layout and boundaries of our button panel
		buttonPanel.setBounds(0, 600, 500, 100);

		//add it to the JFrame
		add(buttonPanel);

		//>>>>> The myTitle code
		myTitle = new TextPicture("Move the Minion!", 150, 30);
		myTitle.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 24));

		//add the title 
		myTitle.setBounds(0, 0, 500, 40);
		add(myTitle);

		//>>>>> The myIcon code
		//create the ImagePicture object and add it to the drawing panel
		myIcon = new ImagePicture(new ImageIcon("minion.png"));

		myIcon.setBounds(0, 0, drawingPanel.getWidth(), drawingPanel.getHeight());
		drawingPanel.add(myIcon);

		//use the Die class to randomly palce my minion
		d = new Die(drawingPanel.getHeight()-myIcon.getMyHeight());

		myIcon.setyPos(d.getValue());


		//>>>>> The buttons
		btnStart = new JButton("Start the minion");
		btnExit = new JButton("End");


		//add the buttons to the button panel
		buttonPanel.add(btnStart);
		buttonPanel.add(btnExit);

		//add the buttons as listeners
		btnStart.addActionListener(this);
		btnExit.addActionListener(this);


		//>>>>> The timer code
		iconTimer = new Timer (20, this);	//fires every 20 milliseconds and sends an event to this frame object
		iconTimer.setInitialDelay(5);
		iconTimer.addActionListener(this);

		//set the window visible to add everyone's paint methods
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	/*
	 * Method to listen to events
	 */
	public void actionPerformed(ActionEvent evt) {
		//check which event is coming
		if(evt.getSource() == btnStart) {
			iconTimer.start();
		}
		else if(evt.getSource() == iconTimer) {
			int y = myIcon.getyPos();
			y+=5;
			myIcon.setyPos(y);
			repaint();
			//checks if my icon has gone beyond my drawing panel height
			if( (myIcon.getyPos() + myIcon.getMyHeight()) > drawingPanel.getHeight()) {
				iconTimer.stop();
			}

		}
		else if(evt.getSource() == btnExit) {
			System.exit(0);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		GameUI myGame = new GameUI();






	}

}
