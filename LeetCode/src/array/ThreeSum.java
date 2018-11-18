package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Leetcode No.15 medium
 */
public class ThreeSum {
	/*
	 //O(N^2Logn)
	 public List<List<Integer>> threeSum(int[] nums) {
     	List<List<Integer>> ans = new ArrayList();
		Arrays.sort(nums);
		for(int i=0;i<nums.length;i++) {
			int sum = nums[i];
         if(i>0&&nums[i]==nums[i-1]) continue;
			for(int j=i+1;j<nums.length;j++) {
             if(j>i+1&&nums[j] == nums[j-1]) continue;
				sum += nums[j];
				int target = -sum;
				int lo = j+1;
				int hi = nums.length;
				while(lo<hi) {
					int mid = (lo+hi)/2;
					if(nums[mid] == target) {
						List<Integer> list = new ArrayList();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[mid]);
						ans.add(list);
						break;
					}
					else if(nums[mid]>target) {
						hi = mid;
					}
					else {
						lo = mid+1;
					}
				}
             sum-=nums[j];
			}
		}
		return ans;
 	}*/
	
	//O(N^2)
	public List<List<Integer>> threeSum(int[] nums) {
	    List<List<Integer>> ans = new ArrayList();
		Arrays.sort(nums);
		for(int i=0;i<nums.length;i++) {
	        if(i>0&&nums[i]==nums[i-1]) continue;
			int left = i+1, right = nums.length;
			while(left < right) {
				if(nums[left]+nums[right] + nums[i] == 0) {
					List<Integer> list = new ArrayList();
					list.add(nums[i]);
					list.add(nums[left]);
					list.add(nums[right]);
					ans.add(list);
					while(left<nums.length-1&&nums[left+1]==nums[left]) {
						left ++;
					}
					while(right>0&&nums[right-1]==nums[right]) {
						right --;
					}
				}
				if(nums[left]+nums[right] + nums[i] > 0) {
					right --;
				}
				else left ++;
			}			
		}
		return ans;
	}
}
