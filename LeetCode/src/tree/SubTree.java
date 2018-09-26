package tree;

/*
 * LeetCode No.572 easy
 */
public class SubTree {
    boolean isSet = false; // Means we have chosen the node that may be the root of subtree
    public boolean isSubtree(TreeNode s, TreeNode t) {
		 if(s!=null && t == null)
			 return false;
		 if(s==null&& t!=null)
			 return false;
		 if(s==null && t == null)
			 return true;
		 boolean flag1=false,flag2 = false;
		 if(s.val==t.val) {
            isSet = true;
			 flag1 = isSubtree(s.left,t.left) && isSubtree(s.right,t.right);
            isSet = false;
			 if(flag1) return true;
		 }
        if(!isSet)
		    return isSubtree(s.left,t) || isSubtree(s.right,t);
        else
            return false;
	 }
}
