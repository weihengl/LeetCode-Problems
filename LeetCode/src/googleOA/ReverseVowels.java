package googleOA;

/*
 * Leetcode No.345 easy
 * Reverse vowels in a string.
 */
public class ReverseVowels {
	public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        int l = 0;
        int r = str.length-1;
        while(l<r) {
        	System.out.println(l + ";"+ r);
        	while(!isVowel(str[l])&&l<r)l++;
        	while(!isVowel(str[r])&&r>l)r--;
        	char temp = str[l];
        	str[l] = str[r];
        	str[r] = temp;
        	l++;
        	r--;
        }
        return new String(str);
    }
	
	public boolean isVowel(char a) {
		return a == 'a' || a == 'A' || a == 'e' || a == 'E' || a == 'i' 
				|| a == 'I' || a == 'o' || a == 'O' || a == 'u' || a == 'U';
	}
	
	public static void main(String[] args) {
		new ReverseVowels().reverseVowels("oe");
	}
}
