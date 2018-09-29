package googleOA;

/*
 * Leetcode No.50 medium
 * Implement pow(x,n);
 */
public class Pow {
	public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n == -1) return 1/x;
        if(n%2 == 0)
            return myPow(x*x,n/2);
        else
            return x * myPow(x*x,(n-1)/2);
    }
}
