package googleOA;

/*
 * Leetcode No.421 medium
 * Trie
 */
public class MaxXOR {
	public int findMaximumXOR(int[] nums) {
		Trie root = new Trie(0);
        for(int i=0;i<nums.length;++i) {
        	root.insert(nums[i], 31);
        }
        Trie temp = root;
        return getXOR(root,root);
    }
	
	int getXOR(Trie node1, Trie node2) {
		if(node1.left==null&&node1.right==null) { // last level
			return 0;
		}
		if(node1.left==null) {
			if(node2.left==null)
				return getXOR(node1.right,node2.right);
			else {
				return node2.left.val + getXOR(node1.right,node2.left);
			}
		}
		else if(node1.right==null) {
			if(node2.right==null)
				return getXOR(node1.left,node2.left);
			else {
				return node1.left.val + getXOR(node1.left,node2.right);
			}
		}
		if(node2.left==null) {
			if(node1.left==null)
				return getXOR(node2.right,node1.right);
			else {
				return node1.left.val + getXOR(node2.right,node1.left);
			}
		}
		else if(node2.right==null) {
			if(node1.right==null)
				return getXOR(node2.left,node1.left);
			else {
				return node2.left.val + getXOR(node2.left,node1.right);
			}
		}
		else {
			return node1.left.val + Math.max(getXOR(node1.left,node2.right),getXOR(node1.right,node2.left));
		}
	}
	
	class Trie{
		Trie left;
		Trie right;
		int val;
		Trie(int x){val = x;}
		void insert(int num, int level) {
			if(level<0)return;
			else {
				if((num&(1<<level))==0) {
					if(right == null) {
						right = new Trie(0);	
					}
					right.insert(num, level-1);
				}
				else {
					if(left == null) {
						left = new Trie(1<<level);	
					}
					left.insert(num, level-1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new MaxXOR().findMaximumXOR(new int[] {3, 10, 5, 25, 2, 8}));
	}
}
