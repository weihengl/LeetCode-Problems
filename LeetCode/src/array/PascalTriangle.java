package array;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/*
 * Leetcode No. 119 easy
 */
public class PascalTriangle {
	 int[][] val;
		public List<Integer> getRow(int rowIndex) {
			val = new int[rowIndex+1][rowIndex+1];
	        for(int i=0;i<rowIndex;++i)
			    Arrays.fill(val[i], 0);
			List<Integer> ans = new ArrayList();
			for(int i=0;i<=rowIndex;++i) {
				ans.add(getVal(rowIndex,i));
			}
			return ans;
		}
		
		public int getVal(int row, int col) {
			if(val[row][col]!=0)
				return val[row][col];
			if(col == 0 || row == 0 || col == row) {
				return val[row][col] = 1;
			}
			val[row][col] = getVal(row-1,col) + getVal(row-1,col-1);
			return val[row][col];
		}
}
