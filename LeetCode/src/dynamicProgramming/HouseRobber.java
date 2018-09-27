package dynamicProgramming;

/*
 * Leetcode No. 213 medium
 * cannot rob adjacent houses(houses are a circle)
 * make profit largest
 */
public class HouseRobber {
	public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        if(len == 1) return nums[0];
        return Math.max(nums[0] + rob(nums,2,len-2), rob(nums,1,len-1));
    }
	
	public int rob(int[] nums, int lo, int hi) { // give restriction to houses can be robbed
		int notrob = 0; // max value you can get from before if you do not rob this house
		int robbed = 0; // max value you can get if you rob this house.
		for(int i=lo;i<=hi;++i) {
			int curr = notrob + nums[i];
			notrob = Math.max(notrob, robbed);
			robbed = curr;
		}
		return Math.max(robbed, notrob);
	}
}
