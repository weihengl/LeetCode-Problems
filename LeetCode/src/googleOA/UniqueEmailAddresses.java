package googleOA;

import java.util.HashSet;
import java.util.Set;

/*
 * Leetcode No.929 easy
 */
public class UniqueEmailAddresses {
	public int numUniqueEmails(String[] emails) {
		int ans = emails.length;
		Set<String> set = new HashSet();
		for(int i=0;i<emails.length;i++) {
			String[] strs = emails[i].split("@");
			strs[0] = getLocal(strs[0]);
			set.add(strs[0]+strs[1]);
		}
		return set.size();
    }
	
	String getLocal(String origin) {
		String erasePlus = origin.split("\\+")[0];
		return erasePlus.replaceAll(".","");
	}
}
