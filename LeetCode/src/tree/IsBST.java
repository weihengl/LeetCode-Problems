package tree;

/*
 * Leetcode No.98 medium
 * Determine whether a binary tree is a BST
 */
public class IsBST {
	
	public boolean isValidBST(TreeNode root) {
        if(root == null)
        	return true;
        if(root.left!=null && root.left.val>=root.val) {
        	return false;
        }
        if(root.right!=null && root.right.val<=root.val) {
        	return false;
        }
        return isValid(root.left,root.val,root.val,1) && isValid(root.right,root.val,root.val,2);
    }
	/*
	@param status
	0 means common
	1 means leftmost, we do not need min
	2 means rightmost, we do not need max
	*/
	public boolean isValid(TreeNode node, int min, int max,int status) {
		if(node==null) return true;
		if(status == 1) {//leftmost min is invalid
			if(node.val>=max)
				return false;
			return isValid(node.left,node.val,node.val,1) && isValid(node.right,node.val,max,0);
		}
		else if(status == 2) {//rightmost max is invalid
			if(node.val<=min)
				return false;
			return isValid(node.left,min,node.val,0) && isValid(node.right,node.val,node.val,2);
		}
		if(node.val>=max || node.val<=min)
			return false;
		return isValid(node.left,min,node.val,0) && isValid(node.right,node.val,max,0);
	}
}
