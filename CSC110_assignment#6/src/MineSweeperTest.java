/*Student Name Oscar Wu
  Student ID V00876811
  assignment #6 2-d arrays
  CSC-110 Fall of 2016
*/
import java.util.*;
import java.util.Random;
 
public class MineSweeperTest {
    //declaring Variables for initializeFullGrid method
    private static int mCol = 8;
    private static int mRow = 8;
    private static int mMines = 10;
    private static String[][] arr;
   
   
    public static void main(String []args){
        MineSweeper mineSweeper = new MineSweeper();
        int row=0;
        int col=0;
        String [][] coveredGrid = new String[8][8];
        for(int i=0;i<mRow;i++){
            for( int j=0;j<mCol;j++){
                coveredGrid[i][j]=". ";
            }
        }
        String[][] actualGrid = initializeFullGrid(coveredGrid);
		System.out.print(" "+" | ");
		for(int i=0; i<8;i++){
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("-------------------");
		for(int j=0; j<8; j++){
			System.out.print(j +" | ");
			for(int k=0; k<8; k++){
				System.out.print(actualGrid[j][k]+" ");
			}
			System.out.println();
		}
        for(int i= 0;i<mRow;i++){
            for( int j=0;j<mCol;j++){
            }
        }
        String[][] Grid = new String[8][8];
        for (int i =0;i < 8;i++) {
            for (int j=0;j< 8;j++) {
                Grid[i][j]= ".";
            }
        }
        drawFullGrid(Grid);
        //this variable is not what it's named, don't get confused
        int unselectedCell = 0;
        Scanner userinput = new Scanner(System.in);
       
        /*this while loop keeps getting input from user until there are only 10 "." left
          or when the user selects a bomb
        */
        while(unselectedCell !=10){
            unselectedCell = 0;
            System.out.println("Select a cell. Row Valule(a digit between 0 and 7): ");
            row = userinput.nextInt();
            while (row<0|| row>7){
                System.out.print("Invalid input.");
                row = userinput.nextInt();
            }
            System.out.println("Select a cell. Colum value(a digit between 0 and 7): ");
            col= userinput.nextInt();
            //this while loop does not seem to be working for col
            while (col<0 || col>7){
                System.out.print("Invalid input.");
                col = userinput.nextInt();
            }
            //when user did not select a bomb
            if(!actualGrid[row][col].equals("*")){ //if the seleced cell is not a bomb
                Grid= revealGridCell(row,col,actualGrid,Grid);
                drawFullGrid(Grid);
                for (int i=0;i<mRow;i++){
                    for( int j=0;j<mCol;j++){
                        if(Grid[i][j].equals(".")){
                            unselectedCell++;
                        }
                    }
                }
            }else{ //if it is a bomb
                for(int i=0; i<8; i++){
                    for(int j=0; j<8; j++){
                        if(actualGrid[i][j].equals("*")){
                            Grid[i][j] = actualGrid[i][j];
                        }
                    }
                }
                Grid[row][col] = "X";//Show X when bomb is selected
                break;
            }
        }
        if(unselectedCell == 10){
            System.out.println("You win!");
        }else{
            System.out.println("Kaboom! Game over!");
            drawFullGrid(Grid);
        }
    }
   
    public MineSweeperTest(){
    arr = new String[mCol][mRow];
        initializeFullGrid(arr);
    }
   
    public static String[][] initializeFullGrid(String[][]arr){
        //I want to have 10 mines in the end
        for(int y = 0; y < mRow; y ++) {
            for(int x = 0; x < mCol; x ++) {
                arr[y][x]=".";
            }
      //go to the next row and print the rest of the columns
        }
        //desired bomb count
        int mMines =10;
        //current bomb count
        int cMines =0;
        Random random = new Random();
        while(cMines < mMines){ //start off with current mine number as 0
            int x = random.nextInt(mRow-1);
            int y = random.nextInt(mCol-1);
            if(arr[y][x] != "*"){
                arr[y][x] = "*";
                cMines ++;
            }
       
        }
        for (int i=0; i<arr.length;i++){
            for (int j=0; j<arr[i].length; j++){
                //if the cell is not a bomb
                if (!arr[i][j].equals("*")){
                /*  The following checking neighbouring bomb cell technique is taught by Wendy Tan
                */
                    int adjacentBombs = 0;
                    //check the (Up1 left1) cell
                    if(i>0 && j>0 && arr[i-1][j-1].equals("*")){
                        adjacentBombs++;
                    }
                    //check Up1
                    if(i-1>=0 && arr[i-1][j].equals("*")){
                        adjacentBombs++;
                    }
                    //check Up1 right1
                    if(i-1>=0 && j+1<arr[i].length && arr[i-1][j+1].equals("*")){
                        adjacentBombs++;
                    }
                    //check Left1
                    if(j-1>=0 && arr[i][j-1].equals("*")){
                        adjacentBombs++;
                    }
                    //check right1
                    if(j+1<arr[i].length && arr[i][j+1].equals("*")){
                        adjacentBombs++;
                    }
                    //check Down1 left1
                    if(i+1<arr.length && j-1>=0 && arr[i+1][j-1].equals("*")){
                        adjacentBombs++;
                    }
                    //check Down1
                    if(i+1<arr.length && arr[i+1][j].equals("*")){
                        adjacentBombs++;
                    }
                    //check Down1 right1
                    if(i+1<arr.length && j+1<arr[i].length && arr[i+1][j+1].equals("*")){
                        adjacentBombs++;
                    }
                    arr[i][j] = Integer.toString(adjacentBombs);
                }
            }
        }return arr;
    }
   
    //this method helps check if each cell is in bondry or not
    public static boolean isAvailable(int row, int col){
        if(row<0 || col>7 || row<0 || col>7) {
            return false;
        }
        return true;
    }
   
    public static String[][] revealGridCell(int row, int col, String[][]fullGrid, String[][] gameboard){
		if(fullGrid[row][col].equals("*")){
			gameboard[row][col]="X";
		}else if(!fullGrid[row][col].equals("0")){
			gameboard[row][col]=fullGrid[row][col];
		}else if(fullGrid[row][col].equals("0")){
            for(int i= -1;i<=1;i++){
                for(int j= -1; j<=1;j++){
                    if(isAvailable(row+i,col+j)){
                        gameboard[row+i][col+j]= fullGrid[row+i][col+j];
                    }
                }
            }
            gameboard[row][col]=" ";
        }
        return gameboard;
    }
        //this method prints the current state of the game in console
    public static void drawFullGrid(String[][]placebomb){
        System.out.println("  | 0 1 2 3 4 5 6 7");
        System.out.println("___________________");
        for(int i = 0; i < placebomb.length; i++) {
        System.out.print(i + " | ");
        for(int j=0; j<placebomb[i].length; j++){
            System.out.print(placebomb[i][j]+" ");
            }
        System.out.println();
        }
 
    }
 
}