package tree;

import java.util.ArrayList;
import java.util.List;

/*
 * Leetcode No.589,590 easy
 */
public class NaryTraversal {
	List<Integer> list = new ArrayList();
	public List<Integer> postorder(Node root) {
		if(root == null) return list;
        for(int i=0;i<root.children.size();++i) {
        	postorder(root.children.get(i));
        }
        list.add(root.val);
        return list;
    }
	
	public List<Integer> preorder(Node root){
		if(root == null) return list;
        list.add(root.val);
        for(int i=0;i<root.children.size();++i) {
        	preorder(root.children.get(i));
        }
        return list;
	}
}
