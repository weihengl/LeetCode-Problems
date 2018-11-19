package misc;

/*
 * Leetcode No.165 medium
 */
public class CompareVersion {
	public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for(int i=0;i<Math.min(v1.length, v2.length);i++) {
        	if(Integer.parseInt(v1[i])>Integer.parseInt(v2[i])){
        		return 1;
        	}
        	else if(Integer.parseInt(v1[i])<Integer.parseInt(v2[i])){
        		return -1;
        	}
        }
        if(v1.length == v2.length) return 0;
        if(v1.length>v2.length) {
        	for(int i=v2.length;i<v1.length;i++) {
        		if(Integer.parseInt(v1[i])!=0) return 1;
        	}
        }
        else {
        	for(int i=v1.length;i<v2.length;i++) {
        		if(Integer.parseInt(v2[i])!=0) return -1;
        	}
        }
        return 0;
    }
}
