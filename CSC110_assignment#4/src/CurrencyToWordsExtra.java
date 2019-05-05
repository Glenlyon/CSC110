/**CurrencyToWords
*Yiliang Liu
*V008699672
*/

import java.util.Scanner;

public class CurrencyToWordsExtra {
	//using array 
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

    //adding a while loop, so that the user can keep inputing number until they want to exit
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please type a number between 0 and 999 OR type -1 to exit:  ");
        double value = scanner.nextDouble();
		double Digits = ((double) value - (int)value)*100;
		String Result = String.format("%.0f", Digits);
        while(value!=-1){
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
        		System.out.print("\nEnter another monetary aomunt or input -1 to exit:  ");
        		value = scanner.nextDouble();
        	}
        }
    }
}