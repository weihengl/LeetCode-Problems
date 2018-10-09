package dynamicProgramming;

/*
 * Leetcode No.413 medium
 */
public class ArithmeticSlices {
	public int numberOfArithmeticSlices(int[] A) {
		  int len = A.length;
	        if(len<=2) return 0;
	        int interval = 0;
	        boolean flag = false;
	        int count = 0;
	        int number = 0;
	        for(int i=1;i<len;++i) {
	        	if(!flag) {
	        		interval = A[i]-A[i-1];
	        		count = 2;
	        		flag = true;
	        	}
	        	else {
	        		if(A[i]-A[i-1] == interval) {
	        			count++;
	        			if(i==len-1) {
	        				if(count>=3) {
	            				number += (count-1)*(count-2)/2;
	            				flag = false;
	            			}
	        			}
	        		}
	        		else {
	        			if(count>=3) {
	        				number += (count-1)*(count-2)/2;
	        			}
	                    i--;
	                    flag = false;
	        		}
	        	}
	        }
	        return number;
    }
}
