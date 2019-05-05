import java.io.*;             //for file
import java.util.Scanner;     //for Scanner

/*
*Xiaole Tan
*V00868734
*Assignment 5: 1D arrays, file input/output, and exceptions
*/

public class Test{

    public static void main (String[] args){
      try{
        //prompt for a file name.
        Scanner console = new Scanner (System.in);
        System.out.print("Type a file name to use: ");
        String filename = console.nextLine();
        Scanner input = new Scanner (new File(filename));
        int totalWords = NumofWords(filename);
        String [] numWords = new String[totalWords];
        //create array and read words from file to array.
        for (int i=0; i<totalWords; i++){
          numWords [i] = input.next();
        }

        //call methods/print output
        String LongestWord = FoundLongestWord(filename);
        int wordlist = NumWordlist(filename);
        int count = NumofWords(filename);


        System.out.println("TEXT FILE STATISTIC");
        System.out.println("-------------------");
        System.out.println("Length of longest word: "+ LongestWord.length() + "(\"" + LongestWord + "\")");
        System.out.println("Number of words in file wordlist: " + wordlist);
        System.out.println("Number of words in file: "+ count);
        System.out.println();
        Wordfrequency(filename,arr);
        System.out.println();
        WordListDump(filename, n, arr);
      }
      catch (FileNotFoundException ex) {
        //program will quit if file not found.
        System.out.println("Error: File not found.");
        System.exit(-1);
      }
    }

    //Number of words in File:
    public static int NumofWords (String filename) throws FileNotFoundException{
      //open file
      Scanner input = new Scanner(new File(filename));
      //Find number of words in File.
      int count = 0;
      while (input.hasNext()) {
        String w = input.next();
        count++;
      }
      return count;
    }

    //Length of the longest word:
    public static String FoundLongestWord (String filename) throws FileNotFoundException{
      //open file
      Scanner input = new Scanner(new File(filename));
      //Find number of words in File
      String current;
      String LongestWord = "";
      while (input.hasNext()){
        current = input.next();
        if(current.length() > LongestWord.length()){
          current = LongestWord;
        }
      }
      return LongestWord;
    }

    //Find number of words in File wordlist.
    public static int[] NumWordlist (String filename) throws FileNotFoundException{
      //create new array
      int [] arr = new int [wordlist];
      //open file
      Scanner input = new Scanner (new File(filename));
      //Find number of words in wordslist.
      int wordList = 1;
      int  number = 0;
      while (input.hasNext()){
        String text = input.next();
        for (int i=0; i<arr.length; i++){
          String one = arr[i];
          for (int j=0; j<i; j++){
            String two = arr[j];
      if(one.toLowerCase().equals(two.toLowerCase())==false) {
        sum++;
      }
          }
        }
      if(sum==i){
        wordlist++;
      }
      }
      return wordlist;
    }

    //wordlist dump:
    public static void WordListDump (String filename, int n, String[] arr) throws FileNotFoundException{
      String [] worddump = new String [n];
      int a = 1;
      int b = 1;
      worddump[0] = arr[0].toLowerCase();
      while (s < worddump.length){
    	  int s = 0;
    	  for (int i=0; i<a && a<arr.length; i++){
    		  if(arr[i].toLowerCase().equals(arr[a].toLowerCase()) == false){
    			  s++;
    		  }
    	  }
    	  if (s == a){
    		  worddump [b] = arr[a].toLowerCase();
    		  b++;
    	  }
    	  a++;
      }
      System.out.println("Wordlist dump:");
      for (int x=0; x< worddump.length; x++){
    	  int s=0;
    	  String one = worddump[x].toLowerCase();
    	  for (int y=0; y<=x; y++){
    		  String two = arr[y].toLowerCase();
    		  if (one.equals(two)==true){
    			  s++;
    		  }
    	  }
    	  System.out.println(worddump[x].toLowerCase()+": "+s);
      }
    }

    //word-frequency
    public static void WordFrequency (String filename, String[]arr) throws FileNotFoundException{
    	int word1 =0;
    	int word2 =0;
    	int word3 =0;
    	int word4 =0;
    	int word5 =0;
    	int word6 =0;
    	int word7 =0;
    	int word8 =0;
    	int word9 =0;
    	int word10 =0;

    	for(int i=0; i<arr.length; i++){
    		if(arr[i].length() == 1){
    			word1++;
    		}else if (arr[i].length() == 2){
    			word2++;
    		}else if (arr[i].length() == 3){
    			word3++;
    		}else if (arr[i].length() == 4){
    			word4++;
    		}else if (arr[i].length() == 5){
    			word5++;
    		}else if (arr[i].length() == 6){
    			word6++;
    		}else if (arr[i].length() == 7){
    			word7++;
    		}else if (arr[i].length() == 8){
    			word8++;
    		}else if (arr[i].length() == 9){
    			word9++;
    		}else if (arr[i].length() >= 10){
    			word10++;
    		}
    	}
    	System.out.println("Word-frequency statistic");
    	System.out.println(" word-length 1: "+word1);
    	System.out.println(" word-length 2: "+word2);
    	System.out.println(" word-length 3: "+word3);
    	System.out.println(" word-length 4: "+word4);
    	System.out.println(" word-length 5: "+word5);
    	System.out.println(" word-length 6: "+word6);
    	System.out.println(" word-length 7: "+word7);
    	System.out.println(" word-length 8: "+word8);
    	System.out.println(" word-length 9: "+word9);
    	System.out.println(" word-length >= 10: "+word10);
    }



}
