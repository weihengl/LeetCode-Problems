package dynamicProgramming;

/*
 * Leetcode No.256 easy
 */
public class PaintingHouse {
	int len;
	int mincost[][];
	public int minCost(int[][] costs) {
	    len = costs.length;  
	    if(len == 0) return 0;
	    mincost = new int[len][3];
	    for(int i=0;i<len;++i) {
	    	if(i==0) {
	    		mincost[0][0] = costs[0][0];
	    		mincost[0][1] = costs[0][1];
	    		mincost[0][2] = costs[0][2];
	    	}
	    	else {
	    		mincost[i][0] = Math.min(mincost[i-1][1], mincost[i-1][2]) + costs[i][0];
	    		mincost[i][1] = Math.min(mincost[i-1][0], mincost[i-1][2]) + costs[i][1];
	    		mincost[i][2] = Math.min(mincost[i-1][1], mincost[i-1][0]) + costs[i][2];
	    	}
	    }
	    return Math.min(mincost[len-1][0], Math.min(mincost[len-1][1], mincost[len-1][2]));
	}
	
}
