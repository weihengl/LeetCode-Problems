package googleOA;

import java.util.ArrayList;
import java.util.List;
import tree.TreeNode;

/*
 * Leetcode No.173 medium
 */
public class BSTIterator {
	
	int prev;
	int number;
	List<Integer> vals;
    public BSTIterator(TreeNode root) {
        prev = -1;
        number = 0;
        vals = new ArrayList();
        InorderTraversal(root);
    }
    
    public void InorderTraversal(TreeNode node) {
    	if(node == null) return;
    	number ++;
    	InorderTraversal(node.left);
    	vals.add(node.val);
    	InorderTraversal(node.right);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return prev < number-1;
    }

    /** @return the next smallest number */
    public int next() {
        return vals.get(++prev);
    }
}