import java.util.Scanner;

public class PlacingNKnightsInChessBoard {
	
	public static int count = 0 ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		boolean[][] board = new boolean[N][N];
		KnightKilling(board, 0, 0, 0, N, " ");

	}
	
	public static void KnightKilling(boolean[][] board , int row , int column , int kpsf , int tk , String ans) {
		
		if(kpsf == tk) {
			System.out.println(++count + ". " + ans);
			return ;
		}
		
		if(column == board[0].length) {
			row++ ;
			column = 0 ;
		}
		
		if(row == board.length) {
			return ;
		}
		
		if(IsItSafeToPlaceKnight(board, row, column)) {
			board[row][column] = true ;
			KnightKilling(board, row, column + 1, kpsf + 1 , tk , ans + "(" + row + " , " + column + ")");
			board[row][column] = false ;
		}
		
		KnightKilling(board, row, column + 1, kpsf, tk, ans);
	}
	
	public static boolean IsItSafeToPlaceKnight(boolean[][] board , int row ,int column) {
		int[] rowArr = {-1 , -2 , -2 , -1};
		int[] colArr = {-2 , -1 , 1 , 2};
		
		//As I need to check only 4 places where Knight can be placed.
		for(int i = 0 ; i < 4 ; i++) {
			int r = row + rowArr[i] ;
			int c = column + colArr[i];
			
			if(r >= 0 && r < board.length && c >= 0 && c < board[0].length) {
				if(board[r][c] == true) {
					return false ;
				}
			}
		}
		
		
		return true ;
	}

}
