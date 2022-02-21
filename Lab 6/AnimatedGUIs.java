import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * 
 */

/**
 * @author Ashiti
 * Date: November 2021
 * Description: This is the UI class of the application that simulates moving images(SmartMinions) with additional features
 * Method List: AnimatedGUIs()		//Default Constructor
 * 				void actionPerformed(ActionEvent e)			//Method to listen to events and perform the necessary actions
 * 				void placement()		//Method for movements (to reduce repeating code)
 * 				void rollingDice()		//Method for rolling dice (to avoid repeating code)
 * 				static void main(String[] args)		//Self-testing main method
 */
public class AnimatedGUIs extends JFrame implements ActionListener{

	//attributes
	private JPanel drawingPanel, controlPanel;
	private JButton btnStart, btnStop, btnExit;	
	private SmartMinion[] pics;
	private TextPicture myTitle;
	private int[] xPos;
	private int[] yPos;
	private int[] xVel;
	private int[] yVel;
	private Timer timer;   // animation timer
	private int timesMoveClicked = 0; 
	private Die[] dice;   
	private int totImages;


	/**
	 * Default Constructor
	 */
	public AnimatedGUIs() {
		
		super("My Simple Animation Example");  // title for the frame
		setLayout(null); 	//set to a null layout to control the locations
		
		totImages = Integer.parseInt(JOptionPane.showInputDialog("Welcome to my Image Movements simulation!\nHow many images would you like to create?"));

		//>>>>>*** The myTitle code
		myTitle = new TextPicture("It's finally here!!", 100, 30);
		myTitle.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 24));

		//add the title 
		myTitle.setBounds(0, 0, 400, 40);
		add(myTitle);

		//>>>>>*** The drawingPanel code
		drawingPanel = new JPanel();

		//set the layout and boundaries of our drawing panel
		drawingPanel.setLayout(null);
		drawingPanel.setBounds(0, myTitle.getHeight(), 400, 460);

		//>>>>>*** The controlPanel code
		controlPanel = new JPanel();

		//set the layout and boundaries of our button panel
		controlPanel.setBounds(0,600 - 100, 400, 100);

		//add start button to control panel
		btnStart = new JButton("Let's Move");
		controlPanel.add(btnStart);    

		//add stop button to control panel
		btnStop = new JButton("Stop");
		controlPanel.add(btnStop);

		//add exit button to control panel
		btnExit = new JButton("Exit");
		controlPanel.add(btnExit);

		//>>>>>*** Creating pics
		
		this.pics = new SmartMinion [totImages];	
	
		//loop to create each element of the array
		for(int i = 0; i < pics.length; i++) {
			//create 
			pics[i] = new SmartMinion (new ImageIcon("picture.jpg"));

			//set its boundaries
			pics[i].setBounds(0, 0, drawingPanel.getWidth(), drawingPanel.getHeight());   

			//add the image to the drawing panel
			drawingPanel.add(pics[i]); 
		}
		
		//>>>>>***Creating the other required arrays for the positions and velocities
		this.xPos = new int [totImages];
		this.yPos = new int [totImages];
		this.xVel = new int [totImages];
		this.yVel = new int [totImages];
		

		//>>>>>***Creating the required dice for positions and speed
		this.dice = new Die [4];
		dice[0] = new Die(400 - pics[0].getMyWidth());  
		dice[1] = new Die(drawingPanel.getHeight() - pics[0].getMyHeight());
		dice[2] = new Die();
		dice[3] = new Die(500);

		//use method for placing the pics
		placement();

		//add the button and drawing panels to the frame
		add(controlPanel);  
		add(drawingPanel);

		//>>>>> The timer code

		//creates a timer and this class as the listener. set to fire every 20ms
		timer = new Timer (20, this);  
		//set the initial delay to 5 ms before it starts
		timer.setInitialDelay (5); 

		// add buttons as a listeners 
		btnStart.addActionListener(this);
		btnStop.addActionListener(this);
		btnExit.addActionListener(this);
		timer.addActionListener(this);

		// set size and location of frame
		setSize(400,600);  
		setLocation(100,100);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	/*
	 * Method to listen to events and perform the necessary actions
	 */
	public void actionPerformed(ActionEvent e) {
		//if start button clicked
		if (e.getSource()==btnStart){
			
			//set/clear the steps moved by each
			for(int i = 0; i < pics.length; i++) {
				pics[i].setStepsMoved(0);
			}

			//set steps to move for each pic
			for(int i = 0; i < pics.length; i++) {
				
				//set steps to move
				if(dice[3].getValue() > 100) {
					pics[i].setStepsToMove(dice[3].getValue());
				}
				else {
					pics[i].setStepsToMove(100);
				}
				
				//System.out.println("Setting steps to move for pic " + i + " to " + pics[i].getStepsToMove() + " beacuse the die value is " + d4.getValue());
				
				//roll die for next image
				dice[3].rollDie();
			}
			
			//when clicked for the first time
			if(timesMoveClicked == 0) {
				timer.start();
			}
			else {
				//roll dice for the next start
				rollingDice();

				//call method
				placement();
				
				//reset timer
				timer.restart();

			}
			timesMoveClicked++;

		}
		//timer
		else if (e.getSource()==timer){

			//loop 
			for(int i = 0; i < pics.length; i++) {
				
				//skip this iteration and continue to next pic
				if(pics[i].getStepsMoved() == pics[i].getStepsToMove()) {
					continue;
				}
				
				//check for the boundaries to reverse direction
				if (xPos[i] >= (drawingPanel.getWidth() - pics[i].getMyWidth())){
					xVel[i]*=-1;   // reverse speed
				}
				else if (xPos[i] <= 0 ){
					xVel[i]*=-1;   // reverse speed 
				}// if x pos

				if (yPos[i] >= (drawingPanel.getHeight()  - pics[i].getMyHeight())){
					yVel[i]*=-1;   // reverse speed
				}
				else if (yPos[i] <= 0){
					yVel[i]*=-1;   // reverse speed
				}// if ypos

				xPos[i] += xVel[i];
				yPos[i] += yVel[i];

				// change the position of the image
				pics[i].setxPos(xPos[i]);
				pics[i].setyPos(yPos[i]);
				
				//add 1 to the number of steps moved
				pics[i].setStepsMoved(pics[i].getStepsMoved()+1);
				//System.out.println(i + " " + pics[i].getStepsToMove() + " " + pics[i].getStepsMoved());
				
			}

		}
		//stop button
		else if(e.getSource() == btnStop) {
			timer.stop();
		}
		//exit program clicked
		else if(e.getSource() == btnExit) {
			System.exit(0);
		}
	}

	/**
	 * Method for movements (to reduce repeating code)
	 */
	public void placement() {
		//use loop to initialize the respective variables
		for(int i = 0; i < pics.length; i++) {

			// place the image based on the first two dice
			xPos[i] = dice[0].getValue();
			yPos[i] = dice[1].getValue();
			pics[i].setxPos(xPos[i]);
			pics[i].setyPos(yPos[i]);

			// set the speed based on the value to the third die
			xVel[i] = dice[2].getValue();
			yVel[i] = dice[2].getValue();

			//roll dice for the next image
			rollingDice();
		}

	}//method

	/*
	 * Method for rolling dice (to avoid repeating code)
	 */
	public void rollingDice() {
		//roll 3 dice
		for(int i = 0; i < (dice.length-1); i++) {
			dice[i].rollDie();
		}
	}

	/**
	 * Self-testing main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		AnimatedGUIs myGame = new AnimatedGUIs();


	}

}
