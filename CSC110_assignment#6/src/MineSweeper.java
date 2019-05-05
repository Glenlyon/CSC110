/**
 * Name: Yiliang Liu
 * Student#: V00869672
 * MineSweeper.java
 */
import java.util.*;

public class MineSweeper {
	public static void main(String[] arg){
		Scanner console=new Scanner(System.in);
		String[][] grid = new String[8][8];
		System.out.print(" "+" | ");
		for(int i=0; i<8;i++){
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("-------------------");
		for(int j=0; j<8; j++){
			System.out.print(j +" | ");
			for(int k=0; k<8; k++){
				grid[j][k]=".";
				System.out.print(grid[j][k]+" ");
			}
			System.out.println();
		}
		String[][] FullGrid = initializeFullGrid(grid);
		System.out.println();
		int row = 0;
		int col = 0;
		String[][] currentGrid = new String[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				currentGrid[i][j]= ".";
			}
		}
		int count = 0;
		while(count != 10){
			count = 0;
            System.out.print("Select a cell. Row Valule(a digit between 0 and 7): ");
            row = console.nextInt();
            while (row<0 || row>7){
                System.out.print("This input is invalid, please input another one: ");
                row = console.nextInt();
            }
            System.out.print("Select a cell. Colum value(a digit between 0 and 7): ");
            col= console.nextInt();
            while (col<0 || col>7){
                System.out.print("This input is invalid, please input another one: ");
                col = console.nextInt();
            }
			if(!FullGrid[row][col].equals("B")){
				currentGrid = revealGridCell(row, col, FullGrid, currentGrid);
				drawFullGrid(currentGrid);
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if(currentGrid[i][j].equals(".")){
							count++;
						}
					}
				}
			}else{
				for(int i=0; i<8; i++){
					for(int j=0; j<8; j++){
						if(FullGrid[i][j].equals("B")){
							currentGrid[i][j] = FullGrid[i][j];
						}
					}
				}
				currentGrid[row][col] = "X";
				break;
			}
		}
		if(count == 10){
			System.out.println("Congrats!!! You win!!!");
			for(int i=0; i<8; i++){
				for(int j=0; j<8; j++){
					if(FullGrid[i][j].equals("B")){
						currentGrid[i][j] = FullGrid[i][j];
					}
				}
			}
			currentGrid[row][col] = "X";
			for(int i=0; i<8; i++){
				for(int j=0; j<8; j++){
					System.out.println(currentGrid[i][j]);
					}
				System.out.println();
			}
		}else{
			System.out.println("Boom!!! You lose!!!");
			System.out.print(" "+" | ");
			for(int i=0; i<8;i++){
				System.out.print(i+" ");
			}
			System.out.println();
			System.out.println("-------------------");
			for(int j=0; j<8; j++){
				System.out.print(j +" | ");
				for(int k=0; k<8; k++){
					System.out.print(currentGrid[j][k]+" ");
				}
				System.out.println();
			}
		}
	}
	//This method will generate a random 8 by 8 grid contains ten bombs.
	//It will also calculate the number of bombs nearby each cell.
	public static String[][] initializeFullGrid(String[][] grid){
		Random rand = new Random();
		int i=0;
		while( i != 10){
			int bombrow = rand.nextInt(8+0);
			int bombcolum = rand.nextInt(8+0);
			if(grid[bombrow][bombcolum] != "B"){
				grid[bombrow][bombcolum] = "B";
				i++;
			}
		}
		for(int j=0; j<grid.length; j++){
			for(int k=0; k<grid.length; k++){
				int count=0;
				if(!grid[j][k].equals("B")){
					if(k+1<grid[j].length){
						if(grid[j][k+1].equals("B")){
							count++;
						}
					}if(j+1<grid.length){
						if(grid[j+1][k].equals("B")){
							count++;
						}
					}if(j+1<grid.length && k+1<grid[j].length){
						if(grid[j+1][k+1].equals("B")){
							count++;		
						}
					}if(j-1>=0){
						if(grid[j-1][k].equals("B")){
							count++;
						}
					}if(j-1>=0 && k+1<grid[j].length){
						if(grid[j-1][k+1].equals("B")){
							count++;
						}
					}if(k-1>=0){
						if(grid[j][k-1].equals("B")){
							count++;
						}
					}if(j+1<grid.length && k-1>=0){
						if(grid[j+1][k-1].equals("B")){
							count++;
						}
					}if(j-1>=0 && k-1>=0){
						if(grid[j-1][k-1].equals("B")){
							count++;
						}
					}
					grid[j][k]= Integer.toString(count);
				}
			}
		}
		return grid;
	}
	//This method will reveal the Grid, whether it is a bomb, empty cell or a number.
	//It will also reveal the cell around an empty cell, if the cell determine by user input is an empty cell.
	public static String[][] revealGridCell(int row, int col, String[][] grid, String[][] revealGrid){
		//String[][] revealGrid = new String[8][8];
		if(grid[row][col].equals("B")){
			revealGrid[row][col]="X";
		}else if(!grid[row][col].equals("0")){
			revealGrid[row][col]=grid[row][col];
		}else if(grid[row][col].equals("0")){
			if(col+1<grid[row].length){
				if(!grid[row][col+1].equals("0")){
					revealGrid[row][col+1] = grid[row][col+1];
				}else{
					revealGrid[row][col+1] = " ";
				}
			}if(row+1<grid.length){
				if(!grid[row+1][col].equals("0")){
					revealGrid[row+1][col] = grid[row+1][col];
				}else{
					revealGrid[row+1][col] = " ";
				}
			}if(row+1<grid.length && col+1<grid[row].length){
				if(!grid[row+1][col+1].equals("0")){
					revealGrid[row+1][col+1] = grid[row+1][col+1];
				}else{
					revealGrid[row+1][col+1] = " ";		
				}
			}if(row-1>=0){
				if(!grid[row-1][col].equals("0")){
					revealGrid[row-1][col] = grid[row-1][col];
				}else{
					revealGrid[row-1][col] = " ";
				}
			}if(row-1>=0 && col+1<grid[row].length){
				if(!grid[row-1][col+1].equals("0")){
					revealGrid[row-1][col+1] = grid[row-1][col+1];
				}else{
					revealGrid[row-1][col+1] = " ";
				}
			}if(col-1>=0){
				if(!grid[row][col-1].equals("0")){
					revealGrid[row][col-1] = grid[row][col-1];
				}else{
					revealGrid[row][col-1] = " ";
				}
			}if(row+1<grid.length && col-1>=0){
				if(!grid[row+1][col-1].equals("0")){
					revealGrid[row+1][col-1] = grid[row+1][col-1];
				}else{
					revealGrid[row+1][col-1] = " ";
				}
			}if(row-1>=0 && col-1>=0){
				if(!grid[row-1][col-1].equals("0")){
					revealGrid[row-1][col-1] = grid[row-1][col-1];
				}else{
					revealGrid[row-1][col-1] = " ";
				}
			}
			revealGrid[row][col] = " ";
		}
		return revealGrid;
	}
	//This method will print out the current grid.
	public static String[][] drawFullGrid(String[][] grid){
		System.out.print(" "+" | ");
		for(int i=0; i<8;i++){
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("-------------------");
		for(int j=0; j<8; j++){
			System.out.print(j +" | ");
			for(int k=0; k<8; k++){
				System.out.print(grid[j][k]+" ");
			}
			System.out.println();
		}
		return grid;
	}
}