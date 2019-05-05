import java.util.Scanner;

public class FutureValueExtra 
{

	public static void main(String[] args) 
	{
		Scanner Console = new Scanner(System.in);
		System.out.print("The starting amount: ");
		double TheStartingAmount = Console.nextDouble();
		System.out.print("The interest rate in percent: ");
		double TheInterestRate = Console.nextDouble();
		double TheInterestRateInPercentage = (double) (TheInterestRate / 100);
		System.out.print("The number of years: ");
		double TheNumberOfYears = Console.nextDouble();
		System.out.println("");
		System.out.println("Y" + " $");
		Console.close();
		for (int i = 0 ; i <= TheNumberOfYears; i++ )
		{
			if(i != 0)
			{
				TheStartingAmount = TheStartingAmount * ( 1 + TheInterestRateInPercentage);
			}
			String Result = String.format("%.2f", TheStartingAmount);
			System.out.println(i + " " + Result);
		}
	}
}
