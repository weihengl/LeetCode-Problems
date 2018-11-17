package googleOA;

/*
 * Leetcode No.482 easy
 */
public class LicenseKeyFormatting {
	public String licenseKeyFormatting(String S, int K) {
		final String str = S.toUpperCase().replace("-","");
        StringBuilder sb = new StringBuilder();
        int counter=0;
        for (int i = str.length()-1; i>=0; --i) {
            sb.append(str.charAt(i));
            counter++;
            if(counter%K == 0 && i!=0) sb.append("-");
        }
        return sb.reverse().toString();
	}
}
