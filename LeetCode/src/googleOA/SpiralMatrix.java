package googleOA;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	int row,col;
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ans = new ArrayList();
		row = matrix.length;
		if(row == 0) return ans;
		col = matrix[0].length;
		if(col == 0) return ans;
		int level = 0;
		int nums = col*row;
		output(matrix,level,ans);
		return ans;
	}
	
	void output(int[][] matrix, int level, List<Integer> ans) {
		if(level*2>=row||level*2>=col) return;
		for(int i=level;i<col-level;i++) {
			ans.add(matrix[level][i]);
		}
		for(int i=level+1;i<row-level;++i) {
			ans.add(matrix[i][col-level-2]);
		}
		if(level == row-level-1)return;
		for(int i=col-level-2;i>=level;--i) {
			ans.add(matrix[row-level-1][i]);
		}
		if(level == col-level-1)return;
		for(int i=row-level-2;i>=level+1;--i) {
			ans.add(matrix[i][level]);
		}	
		output(matrix,level+1,ans);
	}
}
