package googleOA;

/*
 * Google OA 2018 Oct-Dec
 */
public class FindAncestor {
	public int[] find(int[] A, int D) {
		int[] ans = new int[A.length];
		for(int i=0;i<A.length;++i) {
			ans[i] = i;
			int temp = D;
			while(ans[i]!=-1 && temp > 0) {
				ans[i] = A[ans[i]];
				temp--;
			}
		}
		for(int i=0;i<A.length;++i) {
			System.out.print(ans[i] + ";");
		}
		return ans;
	}
	
	public int[] find2(int[] A, int D) {
		 int len = A.length;
	        int[] ans = new int[len];
	        for(int i=0;i<len;++i){
	            ans[i] = i;
	            int temp = D;
	            while(ans[i]!=-1&&temp>0){
	                ans[i] = A[ans[i]];
	                temp --;
	            }
	        }
	    	for(int i=0;i<A.length;++i) {
				System.out.print(ans[i] + ";");
			}
			return ans;
	}
	
	public static void main(String[] args) {
		new FindAncestor().find(new int[] {-1,8,7,6,5,3,2,1,0,4,3}, 5);
		System.out.println();
		new FindAncestor().find2(new int[] {-1,8,7,6,5,3,2,1,0,4,3}, 5);
	}
}
