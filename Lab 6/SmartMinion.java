import javax.swing.ImageIcon;

import javax.swing.JFrame;

import javax.swing.JOptionPane;


/**
 * 
 */

/**
 * @author Ashiti
 * Date: November 2021
 * Description: This class inherits from ImagePicture and allows an image to have a set number of steps
 * Methods List: SmartMinion(ImageIcon img) - SmartMinion Constructor
 * 				 int getStepsToMove() - Method to Get Steps to Move
 *  			 void setStepsToMove(int stepsToMove) - Method to Set Steps to Move
 * 				 int getStepsMoved() - Method to Get Steps Moved
 * 				 void setStepsMoved(int stepsMoved) - Method to Set Steps Moved
 * 				 void main(String[] args) - Self Testing Main Method
 *
 */

public class SmartMinion extends ImagePicture{

	private int stepsToMove;
	private int stepsMoved;

	public SmartMinion(ImageIcon img) {
		super(img);
		stepsToMove = 0;
		stepsMoved = 0;
		repaint();
	}

	public SmartMinion(ImageIcon img, int x, int y) {

		super(img, x, y);
		stepsToMove = 0;
		stepsMoved = 0;
		repaint();
	}


	public int getStepsToMove() {
		return stepsToMove;
	}


	public void setStepsToMove(int stepsToMove) {
		this.stepsToMove = stepsToMove;
	}



	public int getStepsMoved() {
		return stepsMoved;
	}


	public void setStepsMoved(int stepsMoved) {
		this.stepsMoved = stepsMoved;
	}


	/**
	 * @param args
	 * Self Testing Main Method
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) {
		
		//create JFrame
		JFrame frame = new JFrame("Test");
		frame.setSize(800, 350);
		
		//create and add image(using default constructor)
		SmartMinion picDefault = new SmartMinion(new ImageIcon("picture.jpg"));
		frame.add(picDefault);
		frame.setVisible(true);
		JOptionPane.showMessageDialog(null, "Wait");
		
		//create image and add it to JFrame
		SmartMinion pic = new SmartMinion(new ImageIcon("picture.jpg"), 120, 120);
		frame.add(pic);

		
		//pause before starting to move
		JOptionPane.showMessageDialog(null, "Wait");

		//set the steps to move
		pic.setStepsToMove(50);
		
		//loop for moving the image
		for (int i = 0; i <= pic.getStepsToMove(); i++) {
			
			//when the steps moved are less than the 
			if (pic.getStepsMoved() < pic.getStepsToMove()) {
				
				//move the image by 1
				pic.setxPos(pic.getxPos() + 1);
				
				//delay the computer to make the movement look smooth
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//inc steps moved by 1
				pic.setStepsMoved(pic.getStepsMoved()+1);
								
			}
		}
	}
}

