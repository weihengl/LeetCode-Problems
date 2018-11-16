package hashTable;

import java.util.HashMap;
import java.util.Map;

/*
 * Leetcode No.290 easy
 */
public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
		Map<Character,String> map = new HashMap();
        String[] strs = str.split(" ");
        if(strs.length!=pattern.length()) return false;
        for(int i=0;i<strs.length;++i) {
        	if(map.containsKey(pattern.charAt(i))) {
        		if(!map.get(pattern.charAt(i)).equals(strs[i])) return false;
        	}
        	else {
        		if(map.containsValue(strs[i])) return false;
        		map.put(pattern.charAt(i), strs[i]);
        	}
        }
        return true;
    }
	
	public static void main(String[] args) {
		String a = "null";
		String b = null;
		System.out.println(a+b);
	}
}
