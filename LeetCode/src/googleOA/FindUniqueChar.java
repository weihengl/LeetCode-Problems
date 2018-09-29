package googleOA;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Leetcode No.387 easy
 * Find the first unique character in a string
 */
public class FindUniqueChar {

	public int firstUniqChar(String s) {
		char[] str = s.toCharArray();
		Map<Character,Integer> map = new HashMap();
		for(int i=0;i<str.length;++i) {
			if(map.containsKey(str[i])) {
				map.put(str[i], -1);
			}
			else
				map.put(str[i], i);
		}
		int min = -1;
		for(char key : map.keySet()) {
			if(map.get(key) != -1) {
				if(min == -1)
					min = map.get(key);
				else
					min = min < map.get(key)?min:map.get(key);
			}
		}
		return min;
	}
}
