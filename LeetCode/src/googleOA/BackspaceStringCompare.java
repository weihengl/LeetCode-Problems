package googleOA;

import java.util.Stack;

/*
 * NO.844 medium
 */
public class BackspaceStringCompare {
	public boolean backspaceCompare(String S, String T) {
        Stack s = new Stack<Character>();
        Stack t = new Stack<Character>();
        for(int i=0;i<S.length();i++) {
        	if(S.charAt(i)!='#') {
        		s.push(S.charAt(i));
        	}
        	else {
        		if(!s.isEmpty())
        			s.pop();
        	}
        }
        for(int i=0;i<T.length();i++) {
        	if(T.charAt(i)!='#') {
        		t.push(T.charAt(i));
        	}
        	else {
        		if(!t.isEmpty())
        			t.pop();
        	}
        }
        if(s.size()!=t.size()) return false;
        while(!s.isEmpty()) {
        	if(s.pop()!=t.pop()) return false;
        }
        return true;
    }
}
