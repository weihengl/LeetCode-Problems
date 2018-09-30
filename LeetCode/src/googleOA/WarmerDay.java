package googleOA;

import java.util.Arrays;

/*
 * Leetcode No.739 medium
 * Find next bigger number in the array for each element
 */
public class WarmerDay {
	int[] ans;
	public int[] dailyTemperatures(int[] temperatures) {
		 ans = new int[temperatures.length];
		 Arrays.fill(ans, -1);
	     for(int i=0;i<temperatures.length;++i) {
	    	 if(ans[i]==-1){
                if(i>0&&temperatures[i]==temperatures[i-1]){
                    if(ans[i]-1==0) ans[i]=0;
                    else
                        ans[i] = ans[i-1]-1;
                }
                else
	    	        findLargerNumber(temperatures,i,i+1);
             }
	     }
	     return ans;
    }
	
	public int findLargerNumber(int[] nums, final int index, final int start) {
		if(start >= nums.length) {ans[index] =0;return 0;}
		if(nums[start]>nums[index]) {
			ans[index] = start - index;
			return start;
		}
		else {
			if(ans[start]!=-1) return ans[start] + start;
			int next = start;
			do {
				next = findLargerNumber(nums,next,next+1);
			}while(nums[next] <= nums[index] && next != 0);
			if(next == 0) {
				ans[index] = 0;
				return 0;
			}
			else {
				ans[index] = next-index;
				return next;
			}
		}
	}
}
