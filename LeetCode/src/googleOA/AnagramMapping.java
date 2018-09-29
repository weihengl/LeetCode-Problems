package googleOA;

import java.util.HashMap;
import java.util.Map;

/*
 * Leetcode No. 760 easy
 * using map
 */
public class AnagramMapping {
	 public int[] anagramMappings(int[] A, int[] B) {
	       int[] a;
	       int len = A.length;
	       a = new int[len];
	       if(len == 0) return a;
	       Map<Integer,Integer> map = new HashMap();
	       for(int i=0;i<len;++i) {
	    	   map.put(B[i], i);
	       }
	       for(int i=0;i<len;++i) {
	    	   a[i] = map.get(A[i]);
	       }
	       return a;
	 }
}
