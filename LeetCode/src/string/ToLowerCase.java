package string;

public class ToLowerCase {
	public String toLowerCase(String str) {
        char[] s = str.toCharArray();
        for(int i=0;i<s.length;++i) {
        	if(s[i] >= 'A' && s[i] <= 'Z')
        		s[i] += 32;
        }
        return String.valueOf(s);
    }
}
