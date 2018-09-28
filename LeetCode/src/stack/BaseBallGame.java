package stack;

import java.util.ArrayList;
import java.util.List;

/*
 * Leetcode No.682 easy
 */
public class BaseBallGame {
	public int calPoints(String[] ops){
		List<Integer> list = new ArrayList();
		int sum = 0;
		for(int i=0;i<ops.length;++i) {
			if(ops[i].equals("D")) {
				int val = 2 * list.get(list.size()-1);
				list.add(val);
				sum += val;
			}
			else if(ops[i].equals("C")) {
				int val = list.get(list.size()-1);
				list.remove(list.size()-1);
				sum -= val;
			}
			else if(ops[i].equals("+")) {
				int val = list.get(list.size()-1) + list.get(list.size()-2);
				list.add(val);
				sum += val;
			}
			else {
				int val = Integer.parseInt(ops[i]);
				sum += val;
				list.add(val);
			}
		}
		return sum;
	}
}
