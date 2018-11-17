package googleOA;

import java.util.Arrays;

/*
 * Leetcode No.31 medium
 */
public class NextPermutation {
	public void nextPermutation(int[] nums) {
		// Should use constant extra space
		if(nums.length==0) return;
		boolean isMax = true;
		int min = nums[nums.length-1];
		for(int i=nums.length-2;i>=0;--i){
			if(nums[i+1]>nums[i]) {
				isMax = false;
				invert(nums,i);
				return;
			}
		}
		if(isMax) {
			Arrays.sort(nums);
			return;
		}
	}
	
	void invert(int[] nums, int goal) {
		//swap head and tail, invert body
		Arrays.sort(nums,goal+1,nums.length);
		int temp = nums[goal];
		int cur = goal+1;
		while(nums[cur]<=nums[goal]) {
			cur++;
		}
		nums[goal] = nums[cur];
		nums[cur] = temp;
	}
}
