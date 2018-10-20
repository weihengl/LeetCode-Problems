package googleOA;

import java.util.Arrays;

/*
 * Google OA 2018 Oct-Dec
 */
public class StoresAndHouses {
	public int[] findNearest(int[] stores, int[] houses) {
		int n = houses.length;
		int m = stores.length;
		Arrays.sort(stores);
		for(int i=0;i<n;++i) {
			houses[i] = find(houses[i],stores,0,m-1);
		}
		for(int i=0;i<n;++i) {
			System.out.print(houses[i] + ";");
		}
		return houses;
	}
	
	public int find(int target, int[] stores, int lo, int hi) {
		if(lo>hi) return -1;
		int m = (lo+hi)/2;
		if(target == stores[m]) return stores[m];
		if(target < stores[m]) {
			if(m == 0) return stores[m];
			if(target>=stores[m-1]) {
				return target-stores[m-1] > stores[m] - target ? stores[m] : stores[m-1];
			}
			else
				return find(target,stores,lo,m-1);
		}
		else{
			if(m == stores.length-1) return stores[m];
			if(target <= stores[m+1]) return target-stores[m] > stores[m+1] - target ? stores[m+1] : stores[m];
			else return find(target,stores,m+1,hi);
		}
	}
	
	public static void main(String[] args) {
		new StoresAndHouses().findNearest(new int[] {0,1,5,5,11,11,20,1}, new int[] {3,1,6,123,1,3,2,0,-1,8});
	}
}
