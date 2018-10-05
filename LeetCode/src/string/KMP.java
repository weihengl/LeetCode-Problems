package string;

/*
 * KMP's algorithm
 */
public class KMP {
	
	int[] next;
	public int isSubString(String s1, String s2) {
		next = new int[s2.length()];
		getNext(s2);
		int i = 0;
		int j = 0;
		while(i<s1.length()&&j<s2.length()) {
			if(j==-1||s1.charAt(i) == s2.charAt(j)) {
				i++;
				j++;
			}
			else {
				j = next[j];
			}
		}
		if(j==s2.length()) return i-j;
		else
			return -1;
	}
	
	public void getNext(String s) {
		next[0] = -1;
		int j = 0;
		int k = -1;
		while(j<s.length()-1) {
			if(k==-1||s.charAt(j)==s.charAt(k)) {
				next[j+1] = next[j] + 1;
				j++;k++;
			}
			else {
				k = next[k];
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new KMP().isSubString("asdffaaabsasdd","aaabb"));
	}
}
