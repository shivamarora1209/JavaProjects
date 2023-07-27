import java.util.Scanner;

public class SudokuSolver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt() ;
		int[][] board = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				board[i][j] = scn.nextInt();
			}
		}
		scn.close();
	
		Sudoku_Solver(board, 0 , 0 , 1);
		
	}
	
	public static void 	Sudoku_Solver(int[][] board , int row , int column , int number) {
		

		if(row == board.length) {
			for(int i = 0 ; i < board.length ; i++) {
				for(int j = 0 ; j < board[0].length ; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
			System.exit(0);
		}
		
		if(column == board[0].length) {
			Sudoku_Solver(board, row + 1 , 0 , 1);
			return ;
		}
	
		//If Number Reaches 10.
		if(number == 10) {
			return ;	
		}
		
		// placing a number
		if(board[row][column] == 0) {
			if(IsItSafeToPlace(board, row, column, number)) {
				board[row][column] = number ;
				Sudoku_Solver(board , row , column + 1 , 1);
				board[row][column] = 0 ;
			}
			Sudoku_Solver(board , row , column , number + 1);
			return ;	
		}
		
		Sudoku_Solver(board , row , column + 1 , number);	
		return ;
	}
	
	public static boolean IsItSafeToPlace(int[][] board , int row , int column , int data) {
		
		int r ;
		int c ;
				
		//Checking Number inside 3*3 array
		if(row == 2 || row == 5 || row == 8) {
			r =  row - 2 ;
		}else if(row == 1 || row == 4 || row == 7) {
			r = row - 1 ;
		}else {
			r = row ;
		}
		
		if(column == 2 || column == 5 || column == 8) {
			c = column - 2 ;
		}else if(column == 1 || column == 4 || column == 7) {
			c = column - 1 ;
		}else {
			c = column ;
		}
		
		for(int i = r ; i < r + 3 ; i++) {
			for(int j = c ; j < c + 3 ; j++) {
				if(board[i][j] == data) {
					return false ;
				}
			}
		}
		
		
		//Checking Number Vertically Upwards
		r = row - 1;
		c = column ;
		while(r >= 0) {
			if(board[r][c] == data) {
				return false ;
			}
			r-- ;
		}
		//Checking Number Vertically Downwards
		r = row + 1 ;
		c = column ;
		while(r < board.length) {
			if(board[r][c] == data) {
				return false ;
			}
			r++ ;
		}
		
		//Checking Number Horizontally Left
		r = row ;
		c = column - 1 ;
		while(c >= 0) {
			if(board[r][c] == data) {
				return false ;
			}
			c-- ;
		}
		
		//Checking Number Horizontally Right
		r = row ;
		c = column + 1 ;
		while(c < board[0].length){
			if(board[r][c] == data) {
				return false ;
			}
			c++ ;
		}
		
		return true ;
	}

}
