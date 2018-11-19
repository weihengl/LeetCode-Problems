package linked_list;

/*
 * Leetcode No.151 medium
 */
public class ReverseWordsInaString {
	public String reverseWords(String s) {
		if (s == null || s.isEmpty())
	        return "";
	    String[] strArr = s.split(" ");
	    StringBuilder sb = new StringBuilder();
	    for (int i = strArr.length - 1; i >= 0; i--) {
	        if (!strArr[i].isEmpty()) {
			    if (sb.length() == 0) {
				    sb.append(strArr[i]);
			    } else {
				    sb.append(" ").append(strArr[i]);
				}
		    }
	    }
	    return sb.toString();
    }
}
