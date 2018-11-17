package googleOA;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Leetcode No.23 hard
 */
public class MergeSortedLists {
	  public ListNode mergeKLists(ListNode[] lists) {
	        if(lists.length == 0) return null;
	         PriorityQueue<ListNode> pq = new PriorityQueue(lists.length,new Comparator<ListNode>() {
	        	public int compare(ListNode l1, ListNode l2) {
	        		return l1.val-l2.val;
	        	}
	        });
	        for(int i=0;i<lists.length;i++) {
	            if(lists[i]!=null)
	        	pq.add(lists[i]);
	        }
	        ListNode head = new ListNode(0);
	        ListNode prev = head;
	        while(!pq.isEmpty()) {
	        	prev.next = pq.poll();
	        	prev = prev.next;
	        	if(prev.next!=null) {
	        		pq.add(prev.next);
	        	}
	        }
	        return head.next;
	    }
	
	class ListNode{
		int val;
		ListNode next;
		ListNode(int x){val = x;}
	}
}
