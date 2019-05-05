
public class MultiplicationTable {

	public static void main(String[] args) {
		int x;
		int y;
		int z = 0;
		for( x = 0; x <= 10; x++) {
			for (y = 0; y <= 10; y++) 
			{
				z = x*y;
				System.out.println(x+"*"+y+"="+z);
			}
		}
	}

}
