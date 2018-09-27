package hashTable;

import java.util.HashMap;
import java.util.Map;

/*
 * Leetcode No.771 easy
 */
public class JewelsAndStones {
	public int numJewelsInStones(String J, String S) {
		Map<Character,Integer> map = new HashMap();
        for(int i=0;i<J.length();++i) {
        	map.put(J.charAt(i), 0);
        }
        for(int i=0;i<S.length();++i) {
        	if(map.containsKey(S.charAt(i))) {
        		int val = map.get(S.charAt(i));
        		val ++;
        		map.put(S.charAt(i), val);
        	}
        }
        int sum = 0;
        for(int i=0;i<J.length();++i) {
        	sum += map.get(J.charAt(i));
        }
        return sum;
    }
}
