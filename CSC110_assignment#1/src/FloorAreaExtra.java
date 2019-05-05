/**This is a program can be used to calculate all chapels,
 * which have the similar structure as the one provided
 * in the assignment instruction.
 */

import java.util.Scanner;

public class FloorAreaExtra {
	
	public static void main(String[] args) {
		/**Input every DATA please o(n_n)o
		 * Radius of ChapelArea Small = 4.5
		 * Radius of ChapelArea Large = 8
		 * Radius of ChancelArea = 9
		 * Width = 18
		 * Length = 85
		 */
		
		//input the value
		Scanner console = new Scanner(System.in);
		System.out.println("Radius of Chapel Area Small:");
		double rchapelAreaSmall = console.nextDouble();
		System.out.println("Radius of Chapel Area Large:");
		double rchapelAreaLarge = console.nextDouble();
		System.out.println("Radius of Chancel lArea:");
		double rchancelArea = console.nextDouble();
		System.out.println("Width of Chancel Area");
		double width = console.nextDouble();
		System.out.println("Length of Chancel Area");
		double length = console.nextDouble();
		console.close();
		
		//calculating the area of different parts of the chapel
		double chancelArea = rchancelArea*rchancelArea*Math.PI/2+width*length;
		double chapelAreaSmall = rchapelAreaSmall*rchapelAreaSmall*Math.PI/2;
		double chapelAreaLarge = rchapelAreaLarge*rchapelAreaLarge*Math.PI/2;
		
		//calculating the total area of the chapel
		double naveArea = chapelAreaLarge+chapelAreaLarge+chapelAreaSmall+chancelArea;
		System.out.println("The complete area of the cathedral floor=" + naveArea);
	}
}