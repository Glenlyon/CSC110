public class Test
{

	public static  void main (String [] args) 
		{
		for(int i = 1; i < 31; i++)
    		{
        		for(int j = 0; j < 7; j++)
        		{
        			System.out.print(i + "\t");
        			i++;
        			if(j == 6){
        			i--;}
        			if(i > 31)
        			{
        				break;
        			}
        		}
        		System.out.print("\n");
    		}
		}
}