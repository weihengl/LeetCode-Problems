package misc;

/*
 * Leetcode No.547 medium
 */
public class FriendCircle {
	boolean hasGroup[];
	public int findCircleNum(int[][] M) {
		if(M.length == 0) return 0;
		if(M[0].length == 0) return 0;
        hasGroup = new boolean[M.length];
        int ans = 0;
        for(int i=0;i<M.length;i++) {
        	if(!hasGroup[i]) {
        		hasGroup[i] = true;
        		getGroupCircle(M,i);
        		ans ++;
        	}
        }
        return ans;
    }
	
	public void getGroupCircle(int[][] M, int i) {
		for(int j=0;j<M.length;j++) {
			if(!hasGroup[j] && M[i][j] == 1) {
				hasGroup[j] = true;
				getGroupCircle(M,j);
			}
		}
	}
}
