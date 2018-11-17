package googleOA;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Leetcode No.139 medium
 */
public class WordsBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
        /*
         * Dynamic Programming
         * dp[i]=true means the first i chars can be separated into words
         * we need to judge whether dp[s.length] = true;
         */
		Set<String> words = new HashSet(wordDict);
		boolean[] dp = new boolean[s.length()+1];
		dp[0] = true;
		for(int i=1;i<=s.length();i++) {
			for(int j=i;j<=s.length();++j) {
				if(dp[i-1]&&words.contains(s.substring(i-1, j))) dp[j] = true;
			}
		}
		return dp[s.length()];
    }
}
