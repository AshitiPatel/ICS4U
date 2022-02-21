/**
 * 
 */

/**
 * @author Ashiti
 * Date: 26 Oct 2021
 * Description: A program that compares two dice values using a method to check whether they are same or different
 * Method List: boolean compareTo(Die d)		//method to compare my die value to another die
 *				void main(String[] args)		//self-testing main method
 */
public class Die {

	/**
	 * The attributes/data for my objects
	 */
	private int faces;
	private int value;


	/**
	 * Constructor
	 * Creates a regular 6-faced die
	 */
	public Die() {

		//this particular dice has 6 faces (the "this" below is just for readability)
		this.faces = 6;		//set the number of faces
		rollDie(); 		//rolls the die

	}

	/**
	 * Creates a flexible Die - an example of Polymorphism
	 * overloading the constructor
	 */
	public Die(int faces) {
		this.faces = faces;		//set the number of faces based on input
		rollDie();
	}

	//method to roll the die
	public void rollDie() {		//there is no "static" because we don't want to roll everyone's die
		this.value = (int) (Math.random() * this.faces + 1);
	}


	//method to get the value of the die
	public int getValue() {
		return this.value;
	}


	//method to compare my die value to
	//another Die
	public boolean compareTo(Die d) {
		//check if this die is equal to the one from anotherDie
		if(this.getValue() == d.getValue()) {
			return true;
		}
		return false;
	}

	/**
	 * @param args
	 * Self-testing main method
	 */
	public static void main(String[] args) {
		//fully test my class

		//create one die called d1
		Die d1;		//declares d1
		d1 = new Die(); 	//creates the d1 object

		//declare and create a second die called d2
		Die d2 = new Die();

		//roll both dice 100 time and display values whenever they are the same
		for(int i = 0; i < 100; i++) {
			d1.rollDie();
			d2.rollDie();
			//testing compareTo for when it is true
			if(d1.compareTo(d2)) {
				System.out.println(d1.getValue() + " " +  d2.getValue());
			}
			//testing whether it works for when it is false
			else {
				System.out.println(d1.compareTo(d2));
			}
		}
	}
}
