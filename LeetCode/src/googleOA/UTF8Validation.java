package googleOA;

/*
 * Leetcode No.393 medium
 */
public class UTF8Validation {
	public boolean validUtf8(int[] data) {
		int len = data.length;
		if(len==0||len>4) return false;
		int l = getLength(data[0]);
		if(l>len) return false;
		if(l == 1) return true;
		for(int i=1;i<l;++i) {
			if((data[i]&(1<<7))==0 || (data[i]&(1<<6))!=0)
				return false;
		}
		return true;
	}
	
	int getLength(int data) {
		int len = 0;
		for(int i=7;i>=0;--i) {
			if((data&(1<<i))!=0)
				len++;
			else{
				if(len == 0) return 1;
			}
		}
		return len;
	}
}
