package dynamicProgramming;

/*
 * Leetcode No.276 easy
 */
public class PaintFence {
	  int ways[]; // ways[i] means how many ways we have to paint first i fences
		public int numWays(int n, int k) {
			ways = new int[n+1];
			ways[0] = 1;
			if(n==0) return 0;
			if(n==1) return k;
			ways[1] = k;
			ways[2] = k*k;
			/*
			 * we have ways[i-1] ways for painting first i-1 fences, and (k-1)*(ways[i-3]) of them 
			 * ends with adjacent same color.
			 */
	        for(int i=3;i<=n;++i) {
	            if(i==3)
	        	    ways[i] = k*ways[i-1] - k *ways[i-3];
	            else
	                ways[i] = k*ways[i-1]-(k-1)*ways[i-3];
	        }
	        return ways[n];
	    }
}
