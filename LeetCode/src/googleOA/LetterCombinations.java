package googleOA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Leetcode No.17
 */

public class LetterCombinations {
	Map<Character,char[]> map;
    List<String> ans = new ArrayList();
	public List<String> letterCombinations(String digits) {
        initMap();
        if(digits.length() == 0) return ans;
        backTrace(digits,0,"");
        return ans;
    }
	
	void initMap(){
        map = new HashMap();
		map.put('2', new char[]{'a','b','c'});
		map.put('3', new char[]{'d','e','f'});
		map.put('4', new char[]{'g','h','i'});
		map.put('5', new char[]{'j','k','l'});
		map.put('6', new char[]{'m','n','o'});
		map.put('7', new char[]{'p','q','r','s'});
		map.put('8', new char[]{'t','u','v'});
		map.put('9', new char[]{'w','x','y','z'});	
	}
	
	void backTrace(String digits,int index, String prefix) {
		if(index == digits.length()) {
			String pp = new String(prefix);
			ans.add(pp);
            return;
		}
		for(int i=0;i<map.get(digits.charAt(index)).length;i++) {
			backTrace(digits,index+1,prefix+map.get(digits.charAt(index))[i]);
		}
	}
}
