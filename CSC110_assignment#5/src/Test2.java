import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test2 {
	
	public static int wordCount(String Filename) throws FileNotFoundException{	
		Scanner reader = new Scanner(new File(Filename));
		int size = 0;
		while (reader.hasNext()) {
			size++;
			String Text = reader.next();
		}
		reader.close();
		return size;
	}
		
	public static int wordList(String[] words){	
		int wordlist = 1;
		for (int i = 1; i < words.length; i++) {
			int sum = 0;
			String first = words[i];
			for (int a = 0; a < i; a++) {
				String second = words[a];
				if(first.toLowerCase().equals(second.toLowerCase()) == false) {
					sum++;
				}
			}
			if (sum == i) {
				wordlist = wordlist + 1;
			}
		}
		return wordlist;
}
	
	public static void longestWord(String[] words) {
		int max = words[0].length();
		String LongestWord = words[0]; 
		for (int i = 0; i < words.length; i++) {
			if (max < words[i].length()) {
				max = words[i].length();
				LongestWord= words[i];
			}
		}
		System.out.println("Length of longest word: "+ max + " "+ "(\"" + LongestWord + "\")");
	}

	public static void WordFrequency(String[] words) {
		int length1 = 0;
		int length2 = 0;
		int length3 = 0;
		int length4 = 0;
		int length5 = 0;
		int length6 = 0;
		int length7 = 0;
		int length8 = 0;
		int length9 = 0;
		int length10 = 0;
		for(int i=0; i<words.length; i++){
			if(words[i].length()==1){
				length1++;
			} else if(words[i].length()==2){
				length2++;
			} else if(words[i].length()==3){
				length3++;
			} else if(words[i].length()==4){
				length4++;
			} else if(words[i].length()==5){
				length5++;
			} else if(words[i].length()==6){
				length6++;
			} else if(words[i].length()==7){
				length7++;
			} else if(words[i].length()==8){
				length8++;
			} else if(words[i].length()==9){
				length9++;
			} else{
				length10++;
			}
		}
		System.out.println("Word-length 1: " + length1);
		System.out.println("Word-length 2: " + length2);
		System.out.println("Word-length 3: " + length3);
		System.out.println("Word-length 4: " + length4);
		System.out.println("Word-length 5: " + length5);
		System.out.println("Word-length 6: " + length6);
		System.out.println("Word-length 7: " + length7);
		System.out.println("Word-length 8: " + length8);
		System.out.println("Word-length 9: " + length9);
		System.out.println("Word-length >= 10: " + length10);
	}
	
	public static void wordListDump(String[] words, int wordList){
		String [] wordDump = new String [wordList];
		int i = 1;
		int size = 1;
		wordDump[0] = words[0].toLowerCase();
		while (size < wordDump.length) {
			int sum = 0;
			for (int a = 0; a< i && i < words.length; a++) {
				if (words[a].toLowerCase().equals(words[i].toLowerCase()) == false) {
					sum++;
				}
			}
			if (sum == i) {
				wordDump[size] = words[i].toLowerCase();
				size++;
			}
			i++;
		}
		int[] Occurance = new int[wordDump.length];
		for(int j =0; j< wordDump.length; j++){
			int count = 0;
			String element = wordDump[j];
			for(int k = 0; k< words.length; k++){
				if(element.equals(words[k].toLowerCase())){
					count++;
				}
			Occurance[j]=count;
			}
			System.out.println(wordDump[j] +":"+ Occurance[j]);
		}
	}
		
	public static void main(String[] arg){
		try {
			Scanner input=new Scanner(System.in);
			System.out.println("Input the name of file: ");
			String Filename = input.nextLine();
		    File f = new File(Filename);
			Scanner reader = new Scanner(f);
			int size = wordCount(Filename);// call the method which count how many words in the file.
			String [] words = new String[size];


			// by knowing how many words in the file, we are able to creat the array and read each word to the array
			for (int i = 0; i < size; i++) {
				words [i] = reader.next();
			}
			int distinctWords = wordList(words);
			System.out.println("TEXT FILE STATISTICS");
			System.out.println("--------------------");
			longestWord(words);
			System.out.println("Number of words in file wordlist: " + distinctWords);
			System.out.println("Number of words in file: " + size);
			System.out.println("Word_frequency statictics");
			WordFrequency(words);
			System.out.println("Wordlist Dump:");
			wordListDump(words, distinctWords);
			reader.close();
			input.close();
		}catch (FileNotFoundException ex) {
			System.out.println("Error: File not found.");
			System.exit(-1);
		}
	}
}