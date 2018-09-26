package tree;

/*
 * Leetcode No.669 easy
 */
public class TrimBST {
	 public TreeNode trimBST(TreeNode root, int L, int R) {
	        if(root == null) return root;
	        if(L>root.val) {
	        	root.left = null;
	        	root = root.right;
	        	return trimBST(root,L,R);
	        }
	        else if(R<root.val) {
	        	root.right = null;
	        	root = root.left;
	        	return trimBST(root,L,R);
	        }
	        else {
	        	root.right = trimBST(root.right,L,R);
	        	root.left = trimBST(root.left,L,R);
	        }
	        return root;
	    }
}
