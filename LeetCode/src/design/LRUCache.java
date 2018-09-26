package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * Leetcode No.146
 */
public class LRUCache {
	 Map<Integer, Integer> map;
	    LinkedList<Integer> list;
	    int capacity;

	    public LRUCache(int capacity) {
	        map = new HashMap<Integer, Integer>();
	        list = new LinkedList<>();
	        this.capacity = capacity;
	    }

	    public int get(int key) {
	        if (map.containsKey(key)) {
	            list.remove(new Integer(key));
	            list.offer(key);
	            return map.get(key);
	        }
	        return -1;
	    }

	    public void put(int key, int value) {
	        if (map.containsKey(key)) {
	            list.remove(new Integer(key));
	        }
	        list.offer(key);
	        map.put(key, value);

	        if (map.size() > capacity) {
	            int first = list.poll();
	            map.remove(first);
	        }
	    }
}
