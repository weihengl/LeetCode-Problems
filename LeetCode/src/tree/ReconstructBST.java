package tree;

import java.util.ArrayList;
import java.util.List;

/*
 * Leetcode No.897 easy
 * Given a BST, rearrange the tree in in-order so that the 
 * leftmost node in the tree is now the root of the tree, 
 * and every node has no left child and only 1 right child
 */
public class ReconstructBST {
	 List<TreeNode> list;
	 public TreeNode increasingBST(TreeNode root) {
		 list = new ArrayList();
	     InorderTraversal(root);
	     for(int i=0;i<list.size();++i) {
	    	 list.get(i).left = null;
	    	 if(i<list.size()-1)
	    		 list.get(i).right = list.get(i+1);
	     }
	     return list.get(0);
	 }
	 
	 public void InorderTraversal(TreeNode node) {
		 if(node==null) return;
		 InorderTraversal(node.left);
		 list.add(node);
		 InorderTraversal(node.right);
	 }
}
