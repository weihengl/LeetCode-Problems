package googleOA;

import java.util.Arrays;

/*
 * Leetcode No.463 easy
 */
public class IslandPerimeter {
	boolean flag[][];
	public int islandPerimeter(int[][] grid) {
		// we only need to calculate how many 0s are surrounded
		flag = new boolean[grid.length][grid[0].length];
		for(int i=0;i<grid.length;++i) {
			Arrays.fill(flag[i], false);
		}
        for(int i=0;i<grid.length;++i) {
        	for(int j=0;j<grid[0].length;++j) {
        		if(grid[i][j] == 1)
        			return find0s(grid,i,j);
        	}
        }
        return 0;
    }
	
	public int find0s(int[][]g,int row, int col) {
		int sum = 0;
		flag[row][col] = true;
		System.out.println(row + ";" + col);
		if(row == 0) sum ++;
		if(row == g.length-1) sum ++;
		if(col == 0) sum ++;
		if(col == g[0].length -1) sum ++;
		if(row > 0) {
			if(!flag[row-1][col] && (g[row-1][col] == 1))
				sum += find0s(g,row-1,col);
			else if(g[row-1][col] == 0) sum ++;
			System.out.println("sum++");
		}
		if(row < g.length-1) {
			if(!flag[row+1][col] && (g[row+1][col] == 1))
				sum += find0s(g,row+1,col);
			else if(g[row+1][col] == 0) sum ++;
		}
		if(col > 0) {
			if(!flag[row][col-1] && (g[row][col-1] == 1))
				sum += find0s(g,row,col-1);
			else if(g[row][col-1] == 0) sum ++;
		}
		if(col < g[0].length-1) {
			if(!flag[row][col+1] && (g[row][col+1] == 1))
				sum += find0s(g,row,col+1);
			else if(g[row][col+1] == 0) sum ++;
		}
		System.out.println(sum);
		return sum;
	}
	
	public static void main(String[] args) {
		int[][] g = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
		new IslandPerimeter().islandPerimeter(g);
	}
}
