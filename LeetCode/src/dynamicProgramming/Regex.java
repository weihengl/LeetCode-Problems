package dynamicProgramming;



/*
 * Leetcode No.10 hard
 */
public class Regex {
	
	public boolean isMatch(String s1, String s2) {
		char[] p = s2.toCharArray();
		char[] s = s1.toCharArray();
		int sLen = s.length, pLen = p.length; 
		boolean[][] dp = new boolean[sLen+1][pLen+1];
		dp[0][0] = true;
		for (int i = 0; i <= sLen; i++)
		    for (int j = 1; j <= pLen; j++)
		        if (p[j - 1] == '*') 
		            dp[i][j] = dp[i][j - 2] || (i > 0 && (s[i - 1] == p[j - 2] || p[j - 2] == '.') && dp[i - 1][j]);
		        else dp[i][j] = i > 0 && dp[i - 1][j - 1] && (s[i - 1] == p[j - 1] || p[j - 1] == '.');
		return dp[sLen][pLen];
	}
}
