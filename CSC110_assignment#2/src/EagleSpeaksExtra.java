import java.util.Scanner;

public class EagleSpeaksExtra {
	
	public static void printEagle() {
		System.out.println(" \\               /*/");
		System.out.println("  \\\\\\' ,      / //");
		System.out.println("   \\\\\\/'/   _/ //'");
		System.out.println("    \\ _//' /  //<'");
		System.out.println("     \\*///  <//'");
		System.out.println("     /  >>  *\\\\\\ '");
		System.out.println("    /,)-^>>  _\\'");
		System.out.println("    (/   \\\\ / \\\\\\");
		System.out.println("         //  //\\\\\\");
		System.out.println("   /    ((");
		System.out.println("  /");
	}
	
	public static void Speaks() 
	{
		Scanner console = new Scanner(System.in);
		System.out.println("Who are you looking forward to be the next president of the USA? Hillary or Trump?");
		//input Hillary or Trump
		String Eagle_Speaks = console.nextLine();
		String VoteFor = "Trump";
		System.out.println("");
		
		printEagle();	//call the printEagle method
		int y = 1;
		int x = 1;
		int j = 1;
		int k = 1;
		//define x and y for for loop
		
		int a = Eagle_Speaks.length(); //define a class to determine the length of string
		
		if(Eagle_Speaks.equals(VoteFor)) 
		{
			System.out.print("*");
			for(x = 1;x <= a+12 ; x++ )
			{
				System.out.print("-");
			}//first line of "-"
			System.out.println("*");
			
			System.out.println("|" + "  " + "Trump 2016!!!" + "  " + "|");
			//For some reason java don't want Trump to be the president
			
			System.out.print("*");
			for(y = 1;y <= a+12 ; y++ ){
				System.out.print("-");
			} // second line of "-"
			System.out.println("*");
		} 
		
		else 
		{
			System.out.print("*");
			for(j = 1;j <= a+12 ; j++ )
			{
				System.out.print("-");
			} //first line of "-"
			System.out.println("*");
			
			System.out.println("|" + "  " + "Hillary 2016!!!" + "  " + "|");
			//This one is working
			
			System.out.print("*");
			for(k = 1;k <= a+12 ; k++ )
			{
				System.out.print("-");
			} // second line of "-"
			System.out.println("*");
		}
		console.close();
	}

	public static void main(String[] args) {
		Speaks();	
	}
	
}