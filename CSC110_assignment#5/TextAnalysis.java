/**
 * Yiliang Liu
 * Student Number: V00869672
 */

import java.io.*;
import java.util.*;

public class TextAnalysis {

    public static void main(String args[]) throws IOException{
		String text ="";
    	try { 
    		Scanner console = new Scanner (System.in);
    		System.out.println("Input the name of file: ");
    		String FileName = console.nextLine();
    		String Location = "C:/Users/tony1/workspace/assignment#5/src/" + FileName;
    		Scanner input = new Scanner(new File(Location));
    		text = input.nextLine();
    	}
    	catch (FileNotFoundException ex) {
    		System.out.println("Error: File not found.");
    		System.exit(-1);
    	}
    	System.out.println(text);
    }  
}
