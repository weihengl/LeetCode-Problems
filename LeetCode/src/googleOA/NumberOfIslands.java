package googleOA;

/*
 * Leetcode No.200 medium
 */
public class NumberOfIslands {
	boolean isVisited[][];
	int islands = 0;
	public int numIslands(char[][] grid) {
        int rows = grid.length;
        if(rows == 0) return 0;
        int cols = grid[0].length;
        if(cols == 0) return 0;
        isVisited = new boolean[rows][cols];
        for(int i=0;i<rows;++i) {
        	for(int j=0;j<cols;++j) {
        		visit(grid,i,j,true);
        	}
        }
        return islands;
    }
	
	public void visit(char[][] grid, int row, int col,boolean newIsland) {
		if(isVisited[row][col] || grid[row][col] == '0') return;
		isVisited[row][col] = true;
		if(newIsland) islands++;
		if(row>0) {
			visit(grid,row-1,col,false);
		}
		if(row<grid.length-1) visit(grid,row+1,col,false);
		if(col>0) visit(grid,row,col-1,false);
		if(col<grid[0].length-1) visit(grid,row,col+1,false);
	}
}
