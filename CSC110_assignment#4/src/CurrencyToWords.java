/**CurrencyToWords
*Yiliang Liu
*V008699672
*/

import java.util.Scanner;

public class CurrencyToWords {
	//using array to create Strings
    public static void baseCardinalToString(double val, String end) {
        String ones[] = {
        		" ", 
        		"one", 
        		"two", 
        		"three", 
        		"four", 
        		"five", 
        		"six", 
        		"seven", 
        		"eight", 
        		"nine", 
        		"ten", 
        		"eleven", 
        		"twelve", 
        		"thirteen", 
        		"fourteen", 
        		"fifteen", 
        		"sixteen", 
        		"seventeen", 
        		"eighteen", 
        		"nighhteen"
        		};
        String tens[] = {
        		" ", 
        		" ", 
        		"twenty", 
        		"thirty", 
        		"fourty", 
        		"fifty", 
        		"sixty", 
        		"seventy", 
        		"eighty", 
        		"ninety"
        		};
        if (val > 19) {
            System.out.print(tens[(int) (val / 10)] + "-" + ones[(int) (val % 10)]);
        } else {
            System.out.print(ones[(int) val]);
        }
            System.out.print(end);
    }
    
    //use scanner to input a value
    public static double getValueFromUser() {
   	 double value = 0;
   	 boolean completed = false;
		while (!completed) {
			try {
				Scanner scanner = new Scanner (System.in);
				System.out.print("What is the monetary amount?");
				value = scanner.nextDouble() ; 
			    scanner.close();
			    return value;
			}
			catch (Exception e) {
				System.out.println("This is not a number!");}
			}
		return value;
    }
    
    //convert the input value into words
    public static String convertToWords(double value) {
		 double Digits = ((double) value - (int)value)*100;
		 String Result = String.format("%.0f", Digits);
     		if(value>10000) {
     			System.out.println("The value you have input excess the limit!");
         	}else if (value>=0 && value<=10000){
             	if(value>10000) {
             		System.out.println("The value you have input excess the limit!");
                 } else if(value==10000){
                 	System.out.print("Ten Thousand");
                 } else if(value>=1000 && value<10000){
                	 if((int) (value % 1000) == 0) {
                		 baseCardinalToString(((value / 1000) % 10), " thousand ");
                		 System.out.print("-------------------- " + Result + "/100 dollars");
                	 } else if((double)value-(int)(value/1000)*1000<100){
                		 baseCardinalToString(((value / 1000) % 10), " thousand ");
                		 System.out.print("and ");
                		 baseCardinalToString((value % 100), " ");
                		 System.out.print("-------------------- " + Result + "/100 dollars");
                	 } else  {
                		 baseCardinalToString(((value / 1000) % 10), " thousand ");
                		 baseCardinalToString(((value / 100) % 10), " hundred and ");
                		 baseCardinalToString((value % 100), " ");
                		 System.out.print("-------------------- " + Result + "/100 dollars");
                	 }
                 } else if(value>=100 && value<1000){
                	 baseCardinalToString(((value / 100) % 10), " hundred ");
                	 baseCardinalToString((value % 100), " ");
                     System.out.print("-------------------- " + Result + "/100 dollars");
                 } else{
                	 baseCardinalToString((value % 100), " ");
                     System.out.print("-------------------- " + Result + "/100 dollars");
                 }
         }
			return "Not a Valid value";
    }
    
    public static void main(String[] args) {
    	convertToWords(getValueFromUser());
        }
}