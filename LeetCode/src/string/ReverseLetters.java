package string;

/*
 * Leetcode No. 917 easy
 */
public class ReverseLetters {
	public String reverseOnlyLetters(String S) {
        char[] s = S.toCharArray();
        if(s.length == 0) return S;
        String str = "";
        boolean flag[] = new boolean[s.length]; 
        for(int i=0,j=s.length-1;i<s.length;i++) {
        	if((s[i]>='a'&&s[i]<='z')||(s[i]>='A'&&s[i]<='Z')) {
        		while(flag[j]||(s[j]>'z'||s[j]<'a'||(s[j]>'Z'&&s[j]<'a'))) j--;
        		flag[j] = true;
        		str += s[j--];
        	}
        	else {
        		str += s[i];
        		flag[i] = true;
        	}
        }
        return str;
    }
}
