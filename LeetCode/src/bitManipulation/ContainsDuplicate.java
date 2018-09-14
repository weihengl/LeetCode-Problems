package bitManipulation;

import java.util.HashMap;
import java.util.Map;

/*
 * NO.217
 * Given an array of integers, find if the array contains any duplicates.
 */
public class ContainsDuplicate {
	 public boolean containsDuplicate(int[] nums) {
	        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	        int len = nums.length;
	        for(int i=0;i<len;++i){
	            if(map.containsKey(nums[i]))
	                return true;
	            map.put(nums[i],i);
	        }
	        return false;
	    }
}
