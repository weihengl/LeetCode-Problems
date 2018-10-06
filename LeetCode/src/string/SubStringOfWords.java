package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * Leetcode No.30 hard
 */
public class SubStringOfWords {
	 public List<Integer> findSubstring(String s, String[] words) {
	        List<Integer> res = new LinkedList<>();
	        if (s.isEmpty() || s == null || words.length == 0) return res;
	        int wl = words[0].length(), n = s.length(), m = words.length;
	        HashMap<String, Integer> map = new HashMap<>();
	        
	        for (String w : words) 
	            map.put(w, map.getOrDefault(w, 0) + 1);
	        
	        for (int i = 0; i < wl; i++) {
	            HashMap<String, Integer> temp = new HashMap<>();
	            int count = 0;
	            int lo = i;
	            for (int hi = i; hi + wl <= n; hi += wl) {
	                String sHi = s.substring(hi, hi + wl);
	                if (map.containsKey(sHi)) {
	                    temp.put(sHi, temp.getOrDefault(sHi, 0) + 1);
	                    count++;
	                    while (temp.get(sHi) > map.get(sHi)) {
	                        String sLo = s.substring(lo, lo + wl);
	                        temp.put(sLo, temp.get(sLo) - 1);
	                        count--;
	                        lo += wl;
	                    }
	                    if (count == m) {
	                        res.add(lo);
	                        String sLo = s.substring(lo, lo + wl);
	                        temp.put(sLo, temp.get(sLo) - 1);
	                        count--;
	                        lo += wl;
	                    }
	                } else {
	                    temp.clear();
	                    count = 0;
	                    lo = hi + wl;
	                }
	            }
	        }
	        
	        return res;
	    }
}
