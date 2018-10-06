package string;

/*
 * Leetcode No.8 medium
 */
public class Atoi {
	int sign;
	public int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;
        str = str.trim().split(" ")[0];
        if(str.length()==0) return 0;
        if(!isNumber(str)) return 0;
        str = judgeSign(str);
        if(str.length()==0) return 0;
        str = separate(str);
        if(str.length()==0) return 0;
        System.out.println(str);
        if(sign==1) {
        	if(judgeBiggest(str)) {
        		return 2147483647;
        	}
        	else
        		return Integer.parseInt(str);
        }
        else {
        	if(judgeSmallest(str)) {
        		return -2147483648;
        	}
        	else {
        		return -1 * Integer.parseInt(str);
        	}
        }
    }
	
	public boolean isNumber(String str) {
		if(str.charAt(0)<'0'||str.charAt(0)>'9') {
			if(str.charAt(0)=='-'||str.charAt(0)=='+') {
				if(str.length() == 1) return false;
				return str.charAt(1) >= '0' && str.charAt(1) <= '9';
			}
			else
				return false;
		}
		else
			return true;
	}
	
	public String separate(String str) {
		int len = 0;
		boolean isZero = false;
        int st = 0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)<'0'||str.charAt(i)>'9') {
				return str.substring(st, i);
			}
			if(str.charAt(i)=='0'&&!isZero) {
				st++;
			}
            else{
                isZero = true;
                len++;
            }
			if(len>=13) {
				return str.substring(st,i);
			}
		}
		return str.substring(st,str.length());
	}
	
	public String judgeSign(String str) {
		if(str.charAt(0) == '-') {
			sign = -1;
			return str.substring(1, str.length());
		}
		else if(str.charAt(0)=='+') {
			sign = 1;
			return str.substring(1, str.length());
		}
		else {
			sign = 1;
			return str;
		}
		
	}
	
	public boolean judgeBiggest(String str) {
		if(str.length()>10) return true;
		if(str.length()<10) return false;
		else {
			String biggest = "2147483647";
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i)>biggest.charAt(i))
					return true;
                if(str.charAt(i)<biggest.charAt(i))
                    return false;
			}
		}
		return false;
	}
	
	public boolean judgeSmallest(String str) {
		if(str.length()>10) return true;
		if(str.length()<10) return false;
		else {
			String smallest = "2147483647";
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i)>smallest.charAt(i))
					return true;
                if(str.charAt(i)<smallest.charAt(i))
                    return false;
			}
		}
		return false;
	}
}
