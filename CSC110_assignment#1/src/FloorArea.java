
public class FloorArea {
	
	public static void main(String[] args) {
		double chancelArea = 9*9*Math.PI/2+18*85;
		double chapelAreaSmall = 4.5*4.5*Math.PI/2;
		double chapelAreaLarge = 8*8*Math.PI/2;
		double naveArea = chapelAreaLarge+chapelAreaLarge+chapelAreaSmall+chancelArea;
		System.out.println("The complete area of the cathedral floor=" + naveArea);
	}
}