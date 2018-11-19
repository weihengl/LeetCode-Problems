package linked_list;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * Leetcode No.49 medium
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new LinkedList();
        if(strs.length == 0) return ans;
        Map<String,List<String>> map = new HashMap();
        for(int i=0;i<strs.length;i++) {
        	char[] s = strs[i].toCharArray();
        	Arrays.sort(s);
        	String newStr = String.copyValueOf(s);
        	if(!map.containsKey(newStr)) {
        		List l = new LinkedList<String>();
        		l.add(strs[i]);
        		map.put(newStr, l);
        	}
        	else {
        		map.get(newStr).add(strs[i]);
        	}
        }     
        
        return (List)map.values();
    }
}
