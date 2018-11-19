package array;

import java.util.LinkedList;
import java.util.List;

/*
 * Leetcode No.93 medium
 */
public class RestoreIPAddress {
	public List<String> restoreIpAddresses(String s) {
		List<String> ans = new LinkedList();
        if(s.length()>12 || s.length()<4) return ans;
        //we must split it for 3 times brute force, just try
    }
}
