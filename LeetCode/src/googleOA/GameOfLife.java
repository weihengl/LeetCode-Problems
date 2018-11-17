package googleOA;
/*
 * Leetcode No.289 medium
 */
public class GameOfLife {
	/*
	 * 00 die<-die
	 * 01 die<-live
	 * 10 live<-die
	 * 11 live<-live
	 */
	public void gameOfLife(int[][] board) {
		int row = board.length;
		if(row == 0) return;
		int col = board[0].length;
		if(col == 0) return;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				int lives = getLives(board,i,j);
				if(lives == 3){
					board[i][j] += 2; // add 1 to its prefix;
				}
				else if(lives == 2 && board[i][j] == 1) {
					board[i][j]+=2;
				}
			}
		}
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				board[i][j] >>= 1;
			}
		}
	}
	
	int getLives(int[][]board, int x, int y) {
		int lives = 0;
		for(int i=Math.max(0, x-1);i<=Math.min(x+1, board.length-1);i++) {
			for(int j=Math.max(0, y-1);i<=Math.min(y+1, board[0].length-1);j++) {
				if((board[i][j]&1) == 1) lives++;
			}
		}
		if(board[x][y] == 1)
			lives--;
		return lives;
	}
}
