import java.util.Scanner;

public class EagleChat {
		
	public static void Speaks() {
		printEagle();	//call the printEagle method
	
		String Eagle_Speaks = "What's your name?";
		int a = Eagle_Speaks.length(); //define a class to determine the length of string
		int x = 1;
		System.out.print("*");
		for(x = 1;x<=a+2 ; x++ ){
			System.out.print("-");
		} //first line of "-"
		System.out.println("*");
			
		System.out.println("|"+" "+Eagle_Speaks+" "+"|"); //input from scanner
			
		int y = 1;
		System.out.print("*");
		for(y = 1;y<=a+2 ; y++ ){
			System.out.print("-");
		} // second line of "-"
		System.out.println("*");
		
		System.out.println("");
		Scanner Console = new Scanner(System.in);
		System.out.print("My name is ");
		String Name = Console.nextLine();
		int b = Name.length();
		System.out.println("");
		
		printEagle_2();
		
		int j;
		System.out.print("*");
		for(j = 1;j <= b+11 ; j++ )
		{
			System.out.print("-");
		} //first line of "-"
		System.out.println("*");
		
		System.out.println("|" + " " + "Hello " + Name +  "!!!" + " " + "|");
		//This one is working
		
		int k;
		System.out.print("*");
		for(k = 1;k <= b+11 ; k++ )
		{
			System.out.print("-");
		} // second line of "-"
		System.out.println("*");
		
		Console.close();
			
	}

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
	
	public static void printEagle_2() {
		System.out.println("\\*\\              /");
		System.out.println("  \\\\ \\      , '///");
		System.out.println("   \\\\ \\_   \\'\\///");
		System.out.println("   >\\\\  \\ '\\\\_ /");
		System.out.println("     \\\\>  \\\\\\*/");
		System.out.println("     ///*  <<  \\");
		System.out.println("     '/_  <<^-(.\\");
		System.out.println("    /// \\ //   \\)");
		System.out.println("   ///\\\\  \\\\");
		System.out.println("           ))    \\");
		System.out.println("                  \\");
	}


	public static void main(String[] args) {
		Speaks();
	}
		
}

