import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Graphics;
/**
 *
 */

/**
 * @author user
 *
 */
public class Picture extends JComponent{

	/*
	 * private data for Pictures
	 * defines its color, location, and size
	 */
	private Color c;
	private int xPos, yPos, myWidth, myHeight;

	/**
	 * this is the default constructor
	 */
	public Picture() {
		//initializes data
		this.c = Color.RED;
		this.xPos = 0;
		this.yPos = 0;
		this.myWidth = 50;
		this.myHeight = 25;
		repaint(); //calls our paint method
	}

	//our paint method
	public void paint (Graphics g) {
		//set colour
		g.setColor(this.c); 
		
		//draws the shapes
		g.drawRect(this.xPos,this.yPos,this.myWidth,this.myHeight);		
		g.drawOval(this.xPos,this.yPos,this.myWidth,this.myHeight);
		g.fillOval(this.xPos + this.myWidth/4,this.yPos,this.myWidth/2,this.myHeight);

	}

	/*
	 * overloaded constructor for a specific location and dimension
	 */
	public Picture (int x, int y, int w, int h) {
		//initialize the colour variable
		this.c = Color.RED;
		
		//initialize the respective attributes to the given values
		this.xPos = x;
		this.yPos = y;
		this.myWidth = w;
		this.myHeight = h;

		repaint();
	}

	/**
	 * @return the c
	 */
	public Color getC() {
		return c;
	}

	/**
	 * @param c the c to set
	 */
	public void setC(Color c) {
		this.c = c;
		repaint();
	}

	/**
	 * @return the xPos
	 */
	public int getxPos() {
		return xPos;
	}

	/**
	 * @param xPos the xPos to set
	 */
	public void setxPos(int xPos) {
		this.xPos = xPos;
		repaint();
	}

	/**
	 * @return the yPos
	 */
	public int getyPos() {
		return yPos;
	}

	/**
	 * @param yPos the yPos to set
	 */
	public void setyPos(int yPos) {
		this.yPos = yPos;
		repaint();
	}

	/**
	 * @return the myWidth
	 */
	public int getMyWidth() {
		return myWidth;
	}

	/**
	 * @param myWidth the myWidth to set
	 */
	public void setMyWidth(int myWidth) {
		this.myWidth = myWidth;
		repaint();
	}

	/**
	 * @return the myHeight
	 */
	public int getMyHeight() {
		return myHeight;
	}

	/**
	 * @param myHeight the myHeight to set
	 */
	public void setMyHeight(int myHeight) {
		this.myHeight = myHeight;
		repaint();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// create a JFrame to draw my picture
		JFrame f = new JFrame("Frame for testing");
		
		//creates a picture object
		Picture p1 = new Picture(); 
		
		//setting size of JFrame and adding the object
		f.setSize(700, 700);
		f.add(p1); 
		f.setVisible(true);

		// pause before the next step
		JOptionPane.showMessageDialog(null, "wait"); 

		//create a second object (overload one)
		Picture p2 = new Picture(200, 50, 100, 50);

		//add my object to the frame
		f.add(p2); 
		f.setVisible(true);

//		//pause
//		JOptionPane.showMessageDialog(null, "wait"); 
//		p1.setC(Color.BLUE);	//colour change test
//		p2.setC(Color.BLACK);

		//pause
		JOptionPane.showMessageDialog(null, "wait"); 
		p1.setxPos(300);	//x position change test
		p2.setxPos(100);

		//pause
		JOptionPane.showMessageDialog(null, "wait"); 
		p1.setyPos(200);	//y position change test
		p2.setyPos(100);

		//pause
		JOptionPane.showMessageDialog(null, "wait"); 
		p1.setMyHeight(50);		//height change test
		p2.setMyHeight(150);

		//pause
		JOptionPane.showMessageDialog(null, "wait"); 
		p1.setMyWidth(100);		//width change test
		p2.setMyWidth(30);		

	}

}