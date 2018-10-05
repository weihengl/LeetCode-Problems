package string;

/*
 * Manacher's Algorithm
 * Leetcode No.5 medium
 */
public class Manacher {
	public Manacher() {};
	String getPalindrome(String s) {
		String newStr = "$";
	    int len = s.length();
	    for(int i=0;i<len;++i){
	        newStr += "#";
	        newStr += s.charAt(i);
	    }
	    newStr += "#^";
	    len = 2 * len + 3;
	    int[] p = new int[len];
	    int id = 0;
	    int mx = 0;
	    for(int i=1;i<len-1;++i){
	        int st = i + 1;
	        if(i<mx){
	            int j = 2 * id - i;
	            if(p[j] < mx - i){
	                p[i] = p[j];
	                st = i + p[j];
	            }
	            else{
	                st = mx + 1;
	                p[i] = mx-i+1;
	            }
	        }
	        else if(i >= mx) p[i] = 1;
	        for(int k=st;k<len;++k){
	            if(newStr.charAt(k) == newStr.charAt(2*i-k))
	                p[i] ++;
	            else{
	                if(k-1 > mx){
	                    id = i;
	                    mx = k-1;
	                }
	                break;
	            }
	        }
	    }
	    int max = 0;
	    for(int i=1;i<len-1;++i){
	        if(max < p[i]){
	            id = i;
	            max = p[i];
	        }
	    }
	    return newStr.substring(id-max+1,id+max-1).replace("#","");
	}
}
