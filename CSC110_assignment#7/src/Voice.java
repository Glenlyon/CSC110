import java.util.Scanner;

public class Voice {
	private String instrument;
	private String[] notes = new String[0];
	
	public Voice(Scanner input){
		while(input.hasNext()){
			if(input.next().equals("instrument")){
				instrument = input.next();
			}
		}
		
	}
}
