import java.util.Scanner;

public class CalendarCanada {
	
	public static void printSeprator() {
		System.out.print("+");
		for(int x = 1; x <=7 ; x++) {
			for(int y = 1 ; y <= 5; y++) {
				System.out.print("-");
			}
			System.out.print("+");
		}
	}
	
	public static String rightJustify(int value, int spaces) {
		String result = "";
		Integer v = new Integer(value);
		String temp = v.toString();
		int numOfSpace = spaces - temp.length();
		String empty = "";
		for (int i = 0; i<numOfSpace; i++) {
			empty += " ";
		}
		
		result = empty + temp;
		return result;
		
	}
	
	public static void testAll() {
		int days = 31;
		for (int i = 0; i<days; i++) {
			String s = rightJustify(i, 4);
			System.out.println("|" +s + " |");
		}
	}
	
	public static void outputCalendar() 
	{
		
		Scanner Console = new Scanner(System.in);
		System.out.print("Number of days in month? ");
		int numDays = Console.nextInt();
		System.out.print("Date of first Sunday? ");
		int startingSunday = Console.nextInt();
		
		printSeprator();
		System.out.print("\n");
		for(int i = 1; i < 31; i++)
		{
    		for(int j = 0; j < 7; j++)
    		{
    			System.out.print(i + "\t");
    			i++;
    			if(j == 6){
    			i--;
    			}
    			if(i > numDays)
    			{
    				break;
    			}
    		}
    		System.out.print("\n");
		}
			printSeprator();
	}

	public static void main(String[] args) {
		outputCalendar();
		testAll();
	}

}