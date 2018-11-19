package hashTable;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.PriorityQueue;

/*
 * Leetcode No.347 medium
 */
public class TopKFrequentElements {

	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> ans = new LinkedList();
		if(k==0) return ans;
        Arrays.sort(nums);
        PriorityQueue<int[]> pq = new PriorityQueue(k,new Comparator<int[]>(){
        	public int compare(int[] a, int[] b) {
        		return b[1]-a[1];
        	}
        });
        int count = 0;
        for(int i=0;i<nums.length;i++) {
        	if(i!=0) {
        		if(nums[i]!=nums[i-1]) {
        			int[] temp = new int[] {nums[i],count};
        			count = 1;
        			pq.add(temp);
        		}
        		else count++;
        	}
        	else count = 1;
        }
        while(k>0) {
        	k--;
        	ans.add(pq.poll()[0]);
        }
        return ans;
    }
}
