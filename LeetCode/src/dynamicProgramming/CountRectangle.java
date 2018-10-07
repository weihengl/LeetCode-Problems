package dynamicProgramming;

/*
 * Leetcode No.750 medium
 */
public class CountRectangle {
	public int countCornerRectangles(int[][] grid) {
        if(grid.length<=1)return 0;
        int ans = 0;
        for(int i=0;i<grid.length-1;++i) {
        	for(int j=i+1;j<grid.length;++j) {
        		int pairs = 0;
        		for(int k=0;k<grid[0].length;++k) {
        			if(grid[i][k]==1&&grid[j][k]==1)
        				pairs++;
        		}
        		if(pairs>1)
        			ans += (pairs-1)*pairs >> 1;
        	}
        }
        return ans;
    }
}
