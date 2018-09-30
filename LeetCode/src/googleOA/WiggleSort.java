package googleOA;

import java.util.Arrays;

/*
 * Leetcode No.280 medium
 * sort an array makes a[0] <= a[1] >= a[2] <= a[3] >= a[4] ......
 */
public class WiggleSort {
	public int[] wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] ans = new int[nums.length];
        for(int i=0;i<nums.length;++i) {
        	if(i%2==0)
        		ans[i] = nums[i/2];
        	else
        		ans[i] = nums[(i+nums.length)/2];
        }
        return ans;
    }
}
