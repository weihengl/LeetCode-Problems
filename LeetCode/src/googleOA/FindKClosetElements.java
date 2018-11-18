package googleOA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Leetcode No.658 medium
 */
public class FindKClosetElements {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		int index = binarySearch(arr,x,0,arr.length-1);
		List<Integer> list = new ArrayList();
		int[] ans = new int[k];
		ans[k-1] = arr[index];
		k --;
		int prev = index-1, post = index + 1;
		while(k>0) {
			if(prev<0) {
				ans[k-1] = arr[post];
				post ++;
				k --;
			}
			else if(post>= arr.length) {
				ans[k-1] = arr[prev];
				prev--;
				k --;
			}
			else {
				if(Math.abs(arr[prev]-x)>Math.abs(arr[post]-x)){
					ans[k-1] = arr[post];
					post++;
				}
				else {
					ans[k-1] = arr[prev];
					prev--;
				}
				k--;
			}
		}
		Arrays.sort(ans);
		for(int i=0;i<ans.length;i++) {
			list.add(ans[i]);
		}
		return list;
	}
	
	int binarySearch(int arr[], int goal,int lo, int hi) {
		int m = (lo+hi)/2;
		if(arr[m] == goal) return m;
		else if(arr[m]>goal) {
			if(m == 0) return 0;
			if(arr[m-1]>goal) return binarySearch(arr,goal,lo,m-1);
			else {
				// between m and m-1
				return Math.abs(arr[m-1]-goal) < Math.abs(arr[m]-goal) ? m-1 : m;
			}
		}
		else{
			if(m == arr.length-1) return arr.length-1;
			if(arr[m+1]<goal) return binarySearch(arr,goal,m+1,hi);
			else {
				// between m and m+1
				return Math.abs(arr[m+1]-goal) < Math.abs(arr[m]-goal) ? m+1 : m;
			}
		}
	}
	
	/*
	 * better version 
	 * Thought: find the left side of the window of the k elements
	 */
	
	List<Integer> bSearch(int arr[], int k, int x) {
		int lo = 0;
		int hi = arr.length-k;
		while(lo<hi) {
			int mid = (lo+hi)/2;
			if(x-arr[mid]>arr[mid+k]-x)
				lo = mid + 1;
			else
				hi = mid;
		}
		List<Integer> ans = new ArrayList();
		for(int i=0;i<k;i++) {
			ans.add(arr[i+lo]);
		}
		return ans;
	}
}
