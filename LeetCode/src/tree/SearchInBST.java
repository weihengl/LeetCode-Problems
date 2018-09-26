package tree;

/*
 * Leetcode No.700 easy
 */
public class SearchInBST {
	public TreeNode searchBST(TreeNode root, int val) {
		if(root==null) return null;
		if(val == root.val) return root;
		if(val>root.val) return searchBST(root.right, val);
		return searchBST(root.left,val);
	}
}
