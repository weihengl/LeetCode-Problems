/**
 * 
 */
package bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Weiheng Lian
 *
 */
/*
Leetcode No. 279
Given a positive integer n, find the least number of perfect square numbers
 (for example, 1, 4, 9, 16, ...) which sum to n.

*/
public class perfectSquares {
public int numSquares(int n) {
	List<Integer> list = new ArrayList<Integer>();
    //int f[] = new int[n+1];  
    int st = 0;
    int end = 1;
    int step = 0;
    list.add(n);
    while(st<end){
        int temp = end;
        step ++;
        for(int j=st;j<temp;++j){
            int val = list.get(j);
            for(int i=1;;i++){
                if(i*i<val){
                    list.add(val-i*i);
                    end ++;
                }
                else if(i*i==val){
                    return step;
                }
                else
                    break;
            }
        }
        st = temp;
    }
    return 0;
}
	public static void main(String[] args) {
		perfectSquares ps = new perfectSquares();
		System.out.print(ps.numSquares(7));
	}
}
