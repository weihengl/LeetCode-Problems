package dfs;

import java.util.ArrayList;
import java.util.List;

/*
 * Leetcode No.872
 * Two trees are considered leaf-similar when their leaf sequences are same;
 */
public class LeafSimilar {
	List<Integer> list1;
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		list1 = new ArrayList();
		getLeaf(root1);
		return compareLeaf(root2);		
    }
	
	public void getLeaf(TreeNode node) {
		if(node.left==null&&node.right == null)
			list1.add(node.val);
		else{
			if(node.left!=null)
				getLeaf(node.left);
			if(node.right!=null)
				getLeaf(node.right);
		}
	}
	
	public boolean compareLeaf(TreeNode node) {
		if(node.left==null&&node.right == null) {
			if(list1.size() == 0)
				return false;
			if(list1.get(0) != node.val)
				return false;
			list1.remove(0);
			return true;
		}
		else{
			boolean flag1 = true, flag2 = true;
			if(node.left!=null)
				flag1 = compareLeaf(node.left);
			if(node.right!=null)
				flag2 = compareLeaf(node.right);
			return flag1 && flag2;
		}
	}
	
	class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		public TreeNode(int v){val = v;}
	}
}
