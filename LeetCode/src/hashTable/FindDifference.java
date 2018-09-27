package hashTable;

import java.util.HashMap;
import java.util.Map;

/*
 * Leetcode No.389 easy
 */
public class FindDifference {
	public char findTheDifference(String s, String t) {
		Map<Character,Integer> map = new HashMap();
		for(int i=0;i<s.length();++i) {
			if(map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i))+1);
			}
			else
				map.put(s.charAt(i), 1);
		}
		for(int i=0;i<t.length();++i) {
			if(!map.containsKey(t.charAt(i)))
				return t.charAt(i);
			else {
				int v = map.get(t.charAt(i));
				if(v==0)
					return t.charAt(i);
				map.put(t.charAt(i), --v);
			}
		}
		return 'a';
	}
}
