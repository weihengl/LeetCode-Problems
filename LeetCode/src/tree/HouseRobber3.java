package tree;

/*
 * Leetcode No. 337 medium
 * Cannot rob two directly-linked node
 * Make profit largest.
 */
public class HouseRobber3 {
	public int rob(TreeNode root) {
        if(root == null)
        	return 0;
        return rob(root,true);
    }
	
	public int rob(TreeNode node, boolean robbed) {
		if(node == null) return 0;
		if(robbed) 
			return Math.max(node.val + rob(node.left, false)+rob(node.right,false),rob(node.left, true)+rob(node.right,true));
		else
			return rob(node.left, true)+rob(node.right,true);
	}
}
