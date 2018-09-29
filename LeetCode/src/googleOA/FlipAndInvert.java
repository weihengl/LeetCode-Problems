package googleOA;

/*
 * Leetcode No. 832 easy
 * flip means [1,0,3,2] --> [2,3,0,1]
 * invert means [1,0,0,0] --> [0,1,1,1]
 * we only have 0s and 1s 
 */
public class FlipAndInvert {
	public int[][] flipAndInvertImage(int[][] A) {
        for(int i=0;i<A.length;++i) {
        	for(int j=0;j<A[0].length>>1;++j) {
        		if(A[i][j] == A[i][A[0].length-j-1])
        			A[i][j] = A[i][A[0].length-1-j] = 1 - A[i][j];
        	}
        	if(A[0].length%2 == 1)
        		A[i][A[0].length/2] = 1 - A[i][A[0].length/2];
        }
        return A;
    }
}
