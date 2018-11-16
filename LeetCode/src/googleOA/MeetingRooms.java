package googleOA;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Leetcode No. 253 medium
 */
public class MeetingRooms {
	public int minMeetingRooms(Interval[] intervals) {
		int[] startTimes = new int[intervals.length];
		int[] endTimes = new int[intervals.length];
		for(int i=0;i<intervals.length;++i) {
			startTimes[i] = intervals[i].start;
			endTimes[i] = intervals[i].end;
		}
		Arrays.sort(startTimes);
		Arrays.sort(endTimes);
		int usedRooms = 0;
		int start = 0;
		int end = 0;
		while(start < intervals.length) {
			if(startTimes[start]>= endTimes[end]) {
				usedRooms --;
				end ++;
			}
			usedRooms ++;
			start ++;
		}
		return usedRooms;
    }
	
	class Interval{
		int start;
		int end;
		Interval(){start = 0; end = 0;}
		Interval(int s, int e){start = s; end = e;}
	}
}
