package googleOA;

import java.util.Arrays;

/*
 * Leetcode No.406 medium
 */
public class QueueReconstruction {
    public int[][] reconstructQueue(int[][] people) {
        int[][] ans;
        int rows = people.length;
        if(rows == 0) return people;
        int cols = people[0].length;
        ans = new int[rows][cols];
        sort(people,0,rows-1);
        boolean[] flag = new boolean[rows];
        for(int i=0;i<people.length;++i) {
        	int index = people[i][1];
        	for(int j=0;j<=index;++j) {
        		if(flag[j] && ans[j][0]<people[i][0])
        			index++; 		
        	}
        	ans[index][0] = people[i][0];
        	ans[index][1] = people[i][1];
            flag[index] = true;
        }
        return ans;
    }
	
	public void sort(int[][] arr,int l, int r) {
		if(l >= r) return;
		int key = arr[l][0];
		int key1 = arr[l][1];
		int templ = l;
		int tempr = r;
		int index = 0;
		while(templ < tempr) {
			while(arr[tempr][0] >= key && templ < tempr) tempr --;
			arr[templ][0] = arr[tempr][0];
			arr[templ][1] = arr[tempr][1];
			while(arr[templ][0] <= key && templ<tempr) templ++;
			arr[tempr][0] = arr[templ][0];
			arr[tempr][1] = arr[templ][1];
		}
		arr[templ][0] = key;
		arr[templ][1] = key1;
		sort(arr,l,templ-1);
		sort(arr,templ+1,r);
	}
}
