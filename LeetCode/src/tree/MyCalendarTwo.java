package tree;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendarTwo {
	
	TreeMap<Integer,Integer> map;
	public MyCalendarTwo() {
		map = new TreeMap();
	}
	    
	public boolean book(int start, int end) {
		// a time can be booked twice, but not three times
		for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
			
		}
		return false;
	}
}
