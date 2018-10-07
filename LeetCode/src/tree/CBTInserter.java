package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Leetcode No.919 medium
 */
public class CBTInserter {
	TreeNode root;
	 Map<Integer,TreeNode> Nodes = new HashMap();
	 int number = 1;
	 int levels = -1;
	 public CBTInserter(TreeNode root) {
		 this.root = root;
		 List<TreeNode> nodes = new ArrayList();
		 nodes.add(root);
		 int st = 0;
		 int end = 1;
		 while(st<end) {
			 int temp = end;
			 for(int i=st;i<temp;++i) {
				 Nodes.put(number++, nodes.get(i));
				 if(nodes.get(i).left!=null) {
					 nodes.add(nodes.get(i).left);
					 end++;
				 }
				 if(nodes.get(i).right!=null) {
					 nodes.add(nodes.get(i).right);
					 end++;
				 }
			 }
			 st = temp;
		 }
	 }

	 public int insert(int v) {

		 TreeNode node = new TreeNode(v);
		 Nodes.put(number,node);
		 if(number%2==0)
			 Nodes.get(number/2).left = node;
		 else
			 Nodes.get(number/2).right = node;
        		 number ++;
		 return Nodes.get((number-1)/2).val;
	 }
	 
	
	    
	 public TreeNode get_root() {
		 return this.root;
	 }
}
