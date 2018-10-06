package dynamicProgramming;

/*
 * Leetcode No.338 medium
 */
public class CountingBits {
	  public int[] countBits(int num) {
	        int[] ans = new int[num+1];
			ans[0] = 0;
			for(int i=0;i<32;i++) {
				if((1<<i)>num) break;
				for(int j=(1<<i);j<=(1<<i)-1+(1<<i)&&j<=num;j++) {
					ans[j] = 1 + ans[j-(1<<i)];
				}
			}
			return ans;
	    }
}
