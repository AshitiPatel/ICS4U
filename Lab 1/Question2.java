/**
 * 
 */

/**
 * @author Ashiti
 * Date: 15/09/2021
 * Description: A program that displays the sum of ONLY the multiples of 7 from 3 to 47(using FOR LOOP and INFINITE WHILE LOOP)
 *
 */
public class Question2 {

	public static void main(String[] args) {

		//declare and initialize variable for sums
		int sumFor = 0, sumWhile = 0;

		/*
		 * Using for loop
		 */
		System.out.println("Using FOR LOOP");
		for(int i = 3; i <= 47; i++) {

			//multiple of 7
			if((i % 7) == 0) {
				System.out.println("Multiple of 7: " + i);
				sumFor = sumFor + i;
			}

		}

		//display sum
		System.out.println("Sum: " + sumFor);

		/*
		 * Using infinite while loop
		 */
		System.out.println("Using INFINITE WHILE LOOP");

		//declare and initialize variable for numbers(to be used in while loop ONLY)
		int x = 3;

		while(true) {

			//multiple of 7
			if((x % 7) == 0) {
				System.out.println("Multiple of 7: " + x);
				sumWhile = sumWhile + x;
			}

			//break out when 47 reached
			if(x == 47) {
				break;
			}

			x++;

		}

		//display sum for while loop
		System.out.println("Sum: " + sumWhile);

	}

}
