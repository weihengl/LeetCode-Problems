package bfs;

import java.util.ArrayList;
import java.util.List;


/*
 * Leetcode No.515
 * You need to find the largest value in each row of a binary tree.
*/

public class LargestValueInEachTreeRow {
	public List<Integer> largestValues(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        List<Integer> maxValues = new ArrayList<Integer>();
        if(root == null)
        	return maxValues;
        nodes.add(root);
        int st = 0;
        int end = 1;
        int temp = end;
        while(st<end) {
        	temp = end;
        	int max = 0;
        	boolean foundMax = false;
        	for(int i=st;i<temp;++i) {
        		int val = nodes.get(i).val;
        		if(!foundMax) {
        			foundMax = true;
        			max = val;
        		}
        		else
        			max = max >= val ? max : val;
        		if(nodes.get(i).left!=null) {
        			nodes.add(nodes.get(i).left);
        			++end;
        		}
        		if(nodes.get(i).right!=null) {
        			nodes.add(nodes.get(i).right);
        			end ++;
        		}
        	}
        	st = temp;
        	maxValues.add(max);
        }
        return maxValues;
    }
    
	class TreeNode {
    	int val;    
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}
