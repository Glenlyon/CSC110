import java.util.Random;
import java.util.Scanner;

public class test {
	
	private static String[][] map = new String[8][8];
	
	private static String[][] resultMap = new String[8][8];
	
	public boolean fail;
	
	public boolean solved;
	
	public test() {
		init();
	}
	
	private void init() {
		this.fail = false;
		this.solved = false;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				this.map[i][j] = ".";
				this.resultMap[i][j] = ".";
			}
		}
	}
	
	public void isWin() {
		int counter = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (this.resultMap[i][j].equals(".")) {
					counter ++;
				}
			}
		}
		if (counter == 10) {
			this.solved = true;
		}
	}
	
	private void convertValue() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (this.map[i][j].equals(".")) {
					this.map[i][j] = "0";
				}
			}
		}
	}
	
	private void printHeader() {
		System.out.println("  | 0 1 2 3 4 5 6 7");
		System.out.println("-------------------");
	}
	
	private void printMap(String[][] amap) {
		for (int i = 0; i < 8; i++) {
			System.out.print(i + " |");
			for (int j = 0; j < 8; j++) {
				System.out.print(" " +amap[i][j]);
			}
			System.out.print("\n");
		}
	}
	
	private void initEmptyMap() {
		printHeader();
		printMap(this.map);
		
		randomMap();
		System.out.println();
		printHeader();
		printMap(this.map);
	}
	
	private void printResultMap() {
		System.out.println();
		printHeader();
		printMap(this.resultMap);
	}
	
	private void randomMap() {
		Random rand = new Random();
		int i=0;
		while( i != 10){
			int bombrow = rand.nextInt(8+0);
			int bombcolum = rand.nextInt(8+0);
			if(map[bombrow][bombcolum] != "B"){
				map[bombrow][bombcolum] = "B";
				updateCell(bombrow, bombcolum);
				i++;
			}
		}
		this.convertValue();
		
	}
	
	/** check around 8 cells for a given (x, y)
	 * @param aMap
	 * @param x
	 * @param y
	 */
	private void updateCell(int x, int y) {
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {			
				if (isValid(x+i,y+j)) {
					updateMap(x+i, y+j);
				}
			}
		}
	}
	
	private void updateMap(int x, int y) {
		String temp = this.map[x][y];
		if (temp.equals(".")) {
			this.map[x][y] = "1";
		}
		else if (temp.equals("B")) {						
		}
		else {
			int foo = Integer.parseInt(temp);
			foo++;
			this.map[x][y] = String.valueOf(foo);
		} 
	}
	
	private String[][] revealGridCell(String[][] resultMap, int x, int y) {
		String temp = this.map[x][y];
		if (temp.equals("0")){
			for (int i = -1; i < 2; i++) {
				for (int j = -1; j < 2; j++) {			
					if (isValid(x+i,y+j)) {
						updateResultMap(x+i, y+j);
					}
				}
			}
		}
		else if (temp.equals("B")) {
			this.fail = true;
		}
		else {
			this.resultMap[x][y] = temp;
		}
		return this.resultMap;
	}
	
	private void updateResultMap(int x, int y) {
		String temp = this.map[x][y];
		if (temp.equals("B")) {
			this.fail = true;
		}
		else {
			int foo = Integer.parseInt(temp);
			this.resultMap[x][y] = String.valueOf(foo);
		} 
	}
	
	private boolean isValid (int x, int y) {
		if (x<0 || x > 7 || y < 0 || y > 7) {
			return false;
		}
		return true;
	}
	
	public int generator () {
		Random rand = new Random();
		int temp = rand.nextInt(8+0);
		return temp;
	}
	
	

	public static void main(String[] args) {
		
		
		boolean win = false;
		
		while (!win) {
			test t = new test();
			t.initEmptyMap();	
			int row = 0;
			int col = 0;
			Scanner console=new Scanner(System.in);
			boolean quit = false;
			while(!quit) {
				/*
				System.out.println("Select a cell. Row Valule(a digit between 0 and 7): ");
				row = console.nextInt();
				System.out.println("Select a cell. Colum value(a digit between 0 and 7): ");
				col= console.nextInt();
				*/
				
				row = t.generator();
				col = t.generator();
				if (t.isValid(row, col)) {
					t.revealGridCell(resultMap, row, col);
					t.printResultMap();
				}
				else {
					System.out.println("input value out of range, please enter again!");
				}
				if (t.fail == true) {
					System.out.println("You fail the game!");	
					quit = true;
				}
				if (t.solved == true) {
					System.out.println("You win the game!");	
					quit = true;
				}
			}
			if (t.solved == true) {
				win = true;
			}

		}
		
		
	}

}
