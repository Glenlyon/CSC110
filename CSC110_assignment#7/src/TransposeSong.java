import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TransposeSong {

	public static void main(String[] arg){
		try {
			Scanner input=new Scanner(System.in);
			System.out.print("Input the name of file: ");
			String Filename = input.nextLine();
		    File f = new File(Filename);
			Scanner reader = new Scanner(f);
			int i=0;
			String[] header = new String[4];
			while(reader.hasNextLine() && i !=4){
				header[i] = reader.nextLine();
				i++;
			}
			for(int j=0; j<4; j++){
				System.out.println(header[j]);
			}
			//Voice v = new Voice(reader);
		}catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
	}
}
