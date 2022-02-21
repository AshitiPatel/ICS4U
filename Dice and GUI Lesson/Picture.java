import javax.swing.*;
import java.awt.*;
/**
 * @(#)Picture.java
 * @Campos
 * @version 2.00 2017/7/30
 * @Description: Draws a picture on a JFrame.
 */
public class Picture extends JComponent {

	// private data for colour, location and size
	private Color c;
	private int xPos, yPos, myWidth, myHeight;

	// default constructor
	public Picture() {        
		this.c = Color.RED;
		this.xPos = 0;
		this.yPos = 0;
		this.myWidth = 50;
		this.myHeight = 25;
		repaint();
	}

	// constructor for specified location
	public Picture (int x, int y, int w, int h)		
	{
		this.c = Color.RED;
		this.xPos = x;
		this.yPos = y;
		this.myWidth = w;
		this.myHeight = h;
		repaint();
	}

	// setter and getter methods for color
	public void setColor (Color col)
	{
		this.c = col;
		repaint();
	}

	public void setColor (int r, int g, int b)
	{
		this.c = new Color (r,g,b);
		repaint();
	}

	public Color getColor() {
		return c;
	}

	// setter and getter methods for location
	public int getxPos() {
		return xPos;
	}

	protected void setxPos(int xPos) {
		this.xPos = xPos;
		repaint();
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
		repaint();
	} 

	public int getMyWidth() {
		return myWidth;
	}
	
	public void setMyWidth(int w) {
		this.myWidth = w;
		repaint();
	}
	
	public int getMyHeight() {
		return myHeight;
	}

	public void setMyHeight(int h) {
		this.myHeight = h;
		repaint();
	}

	// paint method
	public void paint (Graphics g)  
	{   
		g.setColor(this.c);  // set the new colour
		g.drawRect(this.xPos,this.yPos,this.myWidth,this.myHeight);  // draw shape
		g.drawOval(this.xPos,this.yPos,this.myWidth,this.myHeight);  // draw shape
		g.fillOval(this.xPos+this.myWidth/3,this.yPos,this.myWidth/3,this.myHeight);  // draw shape
	}

	// self testing main method   
	public static void main (String args[]){

		JFrame f = new JFrame("Testing");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Picture p = new Picture();

		f.setSize(400,350);  // size for Frame
		f.add(p);
		f.setVisible(true);

		JOptionPane.showMessageDialog(null,"Wait");
		p.setColor(Color.BLUE);

		JOptionPane.showMessageDialog(null,"Wait");
		p.setColor(50,50,120);  
		JOptionPane.showMessageDialog(null,"Wait");

		Picture p1 = new Picture(200, 50, 100, 50);

		f.add(p1);
		f.setVisible(true);  // repaint fame

		JOptionPane.showMessageDialog(null,"Wait");
		p1.setxPos(10);     // change the position of the p1 object
		p1.setyPos(250);
		
		JOptionPane.showMessageDialog(null,"Wait");
		// change the height and width of the p1 object
		p1.setMyHeight(p1.getMyHeight()/2);
		p1.setMyWidth(p1.getMyWidth()*2);

	}
}