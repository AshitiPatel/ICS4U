import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/*
 *  Class to draw image icons
 *  Inherits from Picture
 */
public class ImagePicture extends Picture {
	 
	private ImageIcon image;  //private data for image
	
	// constructor with image only
	public ImagePicture(ImageIcon img) { 
		super();
		this.image = img;
		setMyWidth(img.getIconWidth());
		setMyWidth(img.getIconHeight());
		repaint();
	}
	
	// constructor for specifying location
	public ImagePicture(ImageIcon img, int x, int y) {  
		super(x,y,img.getIconWidth(), img.getIconHeight());
		this.image = img;
		this.image = img;
		repaint();
	} 
	
	// methods to get the width and height of the Icon
	public int getMyWidth() {
		return this.image.getIconWidth();
	}
	
	public int getMyHeight() {
		return this.image.getIconHeight();
	}
	
	// paint method
	public void paint (Graphics g) {
		 this.image.paintIcon (this, g, getxPos(), getyPos());
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(ImageIcon image) {
		this.image = image;
		repaint();
	}

	public static void main(String args[]) {
		// self testing main method;            
		JFrame f = new JFrame("Testing");
			
		f.setSize(400,350);  // size for graphics
		f.setVisible(true); // paint empty frame
		
		JOptionPane.showMessageDialog(null,"Wait");
		
		// instantiate object p and add it to the frame
		ImagePicture p = new ImagePicture(new ImageIcon("minion.png")); 
		f.add(p);
		f.setVisible(true);  // repaint frame
		
		JOptionPane.showMessageDialog(null,"Wait");
	    
		// instantiate object p1 and add it to the frame
		ImagePicture p1 = new ImagePicture(new ImageIcon("minion.png"), 100, 100);
		f.add(p1);
		f.setVisible(true);  // repaint frame
		
		JOptionPane.showMessageDialog(null,"Wait");
		
		p1.setxPos(50);   // change x and y position of p1 - using setters in Picture                     
		p1.setyPos(80);
		JOptionPane.showMessageDialog(null,"Wait");
		
		p1.setImage(new ImageIcon("gru.png"));// change the image
	}
}
