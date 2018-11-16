package googleOA;

/*
 * Leetcode No.904 medium
 */
public class FruitIntoBaskets {
	public int totalFruit(int[] tree) {
        int first = -1;
        int second = -1;
        int firstEnd = -1;
        int secondEnd = -1;
        int i = 0;
        int max = 0;
        int fruits = 0;
        while(i < tree.length) {
        	if(first == -1 || first == tree[i]) {
        		first = tree[i];
        		firstEnd = i;
        		fruits ++;
        	}
        	else {
        		if(second == -1 || second == tree[i]) {
        			second = tree[i];
        			secondEnd = i;
        			fruits++;
        		}
        		else {
        			max = Math.max(max, fruits);
        			if(secondEnd > firstEnd) {
        				first = tree[i];
        				fruits = i - firstEnd;
        				firstEnd = i;
        			}
        			else {
        				second = tree[i];
        				fruits = i - secondEnd;
        				secondEnd = i;
        			}
        		}
        	}
        	i++;
        }
        max = Math.max(max, fruits);
        return max;
    }
	
	public static void main(String[] args) {
		new FruitIntoBaskets().totalFruit(new int[]{0,1,2,2});
	}
}
