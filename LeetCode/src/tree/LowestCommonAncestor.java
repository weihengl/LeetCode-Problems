package tree;

import java.util.ArrayList;
import java.util.List;

/*
 * Leetcode No.236 medium
 * Given 2 nodes in a binary tree, find their common ancestor
 * All of the nodes' values will be unique. p and q are different
 */
public class LowestCommonAncestor {

	boolean foundp = false;
	boolean foundq = false;
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(q == root || p == root)
			return root;
		List<Integer> pathTop = new ArrayList();
		List<Integer >pathToq = new ArrayList();
		findNode(root,p.val,q.val, pathTop, pathToq);
		for(int i=0;i<pathTop.size()&&i<pathToq.size();i++) {
			int pt = pathTop.get(i);
			int qt = pathToq.get(i);
			if(pt!=qt) return root;
			else if(pt == 1)
				root = root.left;
			else
				root = root.right;
		}
		return root;
    }
	
	public void findNode(TreeNode node, int p, int q, List<Integer> pathTop, List<Integer> pathToq) {
		if(foundp&&foundq) return;
		if(node == null) return;
		if(node.val == p) {
			foundp = true;
			if(foundq)
				return;
		}
		if(node.val == q) {
			foundq = true;
			if(foundp)
				return;			
		}
		if(!foundp)
			pathTop.add(1);
		if(!foundq)
			pathToq.add(1);
		findNode(node.left,p,q,pathTop,pathToq);
		if(!foundp)
			pathTop.remove(pathTop.size()-1);
		if(!foundq)
			pathToq.remove(pathToq.size()-1);
		if(!foundp)
			pathTop.add(2);
		if(!foundq)
			pathToq.add(2);
		findNode(node.left,p,q,pathTop,pathToq);
		if(!foundp)
			pathTop.remove(pathTop.size()-1);
		if(!foundq)
			pathToq.remove(pathToq.size()-1);
	}
}
