package tree;

import java.util.ArrayList;
import java.util.List;

/*
 * Leetcode No. 637 easy
 * calculate the average val of each level in a binary tree
 */
public class LevelAverage {
	List<Double> list;
	List<TreeNode> nodes;
	public List<Double> averageOfLevels(TreeNode root) {
		list = new ArrayList();
		if(root == null) return list;
		nodes = new ArrayList();
		nodes.add(root);
		int start = 0;
		int end = 1;
		int temp = end;
		while(start < end) {
			temp = end;
			long sum = 0;
			int num = 0;
			for(int i=start;i<temp;++i) {
				TreeNode node = nodes.get(i);
				num ++;
				sum += node.val;
				if(node.left!=null) {
					end ++;
					nodes.add(node.left);
				}
				if(node.right!=null) {
					end++;
					nodes.add(node.right);
				}
			}
			start = temp;
			list.add(sum * 1.0 / num);
		}
		return list;
	}
	
}
