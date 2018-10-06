package string;

/*
 * Leetcode No.6 medium
 */
public class ZigZag {
	/*
	 * every 2*n-2 chars is a section 
	 * for first row, index should be i*(2*numRows-2), i=0,1,2...
	 * for middle rows, e.g., row k, index should be i*(2*numRows-2)+-k
	 * for last row,should be i*(2*numRows-2)+numRows-1.
	 */
	public String convert(String s, int numRows) {
		if(s.length()==0||numRows == 1) return s;
		int secs = s.length()%(2*numRows-2)==0 ? s.length()/(2*numRows-2) : s.length()/(2*numRows-2) + 1;
		char[] str = s.toCharArray();
		String ans = "";
		for(int i=0;i<numRows;++i) {
			int st = 0;
			if(i==0) {
				while(st*(2*numRows-2)<str.length) {
					ans += str[st*(2*numRows-2)];
					st++;
				}
			}
			else if(i==numRows-1) {
				while(st*(2*numRows-2)+numRows-1<str.length) {
					ans += str[st*(2*numRows-2)+numRows-1];
					st++;
				}
			}
			else {
				while(st<secs) {
					if(st*(2*numRows-2)+i<str.length) {
						ans += str[st*(2*numRows-2)+i];
					}
					if((st+1)*(2*numRows-2)-i<str.length) {
						ans += str[(st+1)*(2*numRows-2)-i];
					}
					st ++;
				}
			}
		}
		return ans;
	}
}
