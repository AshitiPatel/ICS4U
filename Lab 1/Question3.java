/**
 * 
 */

/**
 * @author Ashiti
 *Date: 15/09/2021
 *Description: An application that switches teams and displays according to the required conditions
 *
 */
public class Question3 {

	public static void main(String[] args) {
		
		//main loop for initial team
		for(int i = 1; i <= 6; i++) {

			//main loop for switching teams
			for(int j = 1; j <= 6; j++) { 

				//continue when same numbers reached
				if(j == i) {
					continue;
				}
				
				//display
				System.out.println("Team " + i + " plays Team " + j);

			}

		}

		






	}

}
