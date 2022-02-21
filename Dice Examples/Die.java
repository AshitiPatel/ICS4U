/**
 * 
 */

/**
 * @author Ashiti
 * Date: 25 Oct 2021
 * Description: A class that defines playing dice
 *
 */
public class Die {

	/**
	 * The attributes/data/properties for my objects
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

	
	//method to compare my die value
	//another Die
	public boolean compareTo(Die anotherDie) {
		//check if this die is equal to the one from anotherDie
		if(this.value == anotherDie.getValue()) {
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

		//check its value
		System.out.println(d1.getValue());

		//roll d1 again
		d1.rollDie();

		//check its value
		System.out.println(d1.getValue());

		//declare and create a second die called d2
		Die d2 = new Die();

		//check its value
		System.out.println(d1.getValue());

		//roll d2 again
		d2.rollDie();

		//check its value
		System.out.println(d1.getValue());
		
		//roll both dice 100 time and display values whenever they are the same
		for(int i = 0; i < 100; i++) {
			d1.rollDie();
			d2.rollDie();
			if(d1.compareTo(d2)) {
				System.out.println(d1.getValue() + " " +  d2.getValue());
			}
		}
		
		//create a flexible Die
		Die d3 = new Die(12);
		
		System.out.println((d3.getValue())); 
		

	}

}
