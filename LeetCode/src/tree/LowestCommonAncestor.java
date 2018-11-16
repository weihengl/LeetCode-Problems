package tree;

import java.util.ArrayList;
import java.util.List;

/*
 * Leetcode No.236 medium
 * Given 2 nodes in a binary tree, find their common ancestor
 * All of the nodes' values will be unique. p and q are different
 * https://www.youtube.com/watch?v=13m9ZCB8gjw
 */

public class LowestCommonAncestor {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || root == p || root == q)
			return root;
		TreeNode left = lowestCommonAncestor(root.left,p,q);
		TreeNode right = lowestCommonAncestor(root.right,p,q);
		return left == null? right : right == null? left : root;
	}
	
}
