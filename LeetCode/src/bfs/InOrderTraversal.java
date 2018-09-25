package bfs;

import java.util.ArrayList;
import java.util.List;

/*
 * LeetCode No. 102
 * Simple in-order traversal of binary tree
 */
public class InOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<bfs.InOrderTraversal.TreeNode>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null)
        	return ans;
        nodes.add(root);
        int st = 0;
        int end = 1;
        int temp = end;
        while(st<end) {
            List<Integer> level = new ArrayList<Integer>();
        	temp = end;
        	for(int i=st;i<temp;++i) {
                level.add(nodes.get(i).val);
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
        	ans.add(level);
        }
        return ans;
    }
	
	class TreeNode {
    	int val;    
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}
