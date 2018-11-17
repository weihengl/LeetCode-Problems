package googleOA;

import java.util.HashMap;
import java.util.Map;

/*
 * Leetcode No.399 medium
 * Union find
 */
public class EvaluateDivision {
	  public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
			int count = 0;
			Map<String,Integer> map= new HashMap();
			double[] relation = new double[2*values.length];
			int[] root = new int[2*values.length];
			for(int i=0;i<values.length;i++) {
				int count0, count1;
				if(!map.containsKey(equations[i][0])) {
					map.put(equations[i][0], count);
					root[count] = count;
					relation[count] = 1;
					count0 = count;
					count ++;
				}
				else count0 = map.get(equations[i][0]);
				if(!map.containsKey(equations[i][1])) {
					map.put(equations[i][1], count);
					root[count] = count;
					relation[count] = 1;
					count1 = count;
					count ++;
				}
				else count1 = map.get(equations[i][1]);
				int hi = Math.max(count0, count1);
				int lo = Math.min(count0, count1);
				if(lo == count0) values[i] = 1 / values[i];
				//always join to low index
				root[hi] = root[lo];
				relation[hi] = values[i] * relation[lo];
			}

			/*
			 * This step: sometimes we need to update the root of a node
			 * Since we merge nodes to those ahead of them in the array
			 * We can update the parents in order.
			 */
	        for(int i=0;i<count;++i){
	            if(root[i]!=root[root[i]]){
	                relation[i] *= relation[root[i]];
	                root[i] = root[root[i]];
	            }
	        }
	        
	        
			double[] ans = new double[queries.length];
			for(int i=0;i<queries.length;i++) {
	            System.out.println(queries[i][0]+queries[i][1]);
	            if(!map.containsKey(queries[i][0])||!map.containsKey(queries[i][1])) {
					ans[i] = -1.0;
					continue;
				}
				if(root[map.get(queries[i][0])]!=root[map.get(queries[i][1])]) {
					ans[i] = -1.0;
				}
				else {
					ans[i] = relation[map.get(queries[i][0])]/relation[map.get(queries[i][1])];
				}
			}
			return ans;
		}
}
