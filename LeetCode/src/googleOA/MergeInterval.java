package googleOA;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/*
 * Leetcode No.56 medium
 * If two intervals overlap, merge them
 */

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class MergeInterval {
	public List<Interval> merge(List<Interval> intervals) {
		if(intervals.size() ==0) return intervals;
        intervals.sort(new MyComparator());
        for(int i=1;i<intervals.size();i++) {
        	if(intervals.get(i).start<=intervals.get(i-1).end) {
        		if(intervals.get(i).end>=intervals.get(i-1).end) {
        			intervals.get(i-1).end = intervals.get(i).end;
        		}
        		intervals.remove(i);
        		i--;
        	}
        }
        return intervals;
    }
	
	class MyComparator implements Comparator<Interval>{
		@Override
		public int compare(Interval o1, Interval o2) {
		     if(o1.start < o2.start) { 
		         return 1;
		     }else if(o1.start > o2.start) {
		         return -1;
		     }else {
		         return 0;
		     }
		}
	}
}
