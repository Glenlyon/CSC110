import java.util.Scanner;

public class EagleSpeaks {
	
	public static void Speaks() {
		Scanner console = new Scanner(System.in);
		System.out.println("What do you want the eagle to speak?");
		String Eagle_Speaks = console.nextLine();
		System.out.println("");
		printEagle();	//call the printEagle method
		
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
		console.close();
		
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
	


	public static void main(String[] args) {
		Speaks();
		
	}
	
}