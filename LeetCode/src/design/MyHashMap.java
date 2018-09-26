package design;

import java.util.Arrays;

/*
 * Leetcode No.706
 */
public class MyHashMap {

	    /** Initialize your data structure here. */
	    int[] keys;
	    public MyHashMap() {
	        keys = new int[1000001];
	        Arrays.fill(keys, -1);
	    }
	    
	    /** value will always be non-negative. */
	    public void put(int key, int value) {
	        keys[key] = value;
	    }
	    
	    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
	    public int get(int key) {
	        return keys[key];
	    }
	    
	    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
	    public void remove(int key) {
	        keys[key] = -1;
	    }
}
