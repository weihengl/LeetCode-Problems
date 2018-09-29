package googleOA;

import java.util.ArrayList;
import java.util.List;

/*
 * Leetcode No.448
 * No extra space (except returned list) and O(n) time
 */
public class FindMissingNumber {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		 List<Integer> ret = new ArrayList<Integer>();
	        
	        for(int i = 0; i < nums.length; i++) {
	            int val = Math.abs(nums[i]) - 1;
	            if(nums[val]>0)
	            	nums[val] = -nums[val];
	        }
	        for(int i = 0; i < nums.length; i++) {
	            if(nums[i] > 0) {
	                ret.add(i+1);
	            }
	        }
	        return ret;
	}
	
	public static void main(String[] args) {
		new FindMissingNumber().findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
	}
}
