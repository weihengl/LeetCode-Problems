package googleOA;

import java.util.Stack;

/*
 *  Leetcode No. 155 easy
 *  Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *  push(x) -- Push element x onto stack.
	pop() -- Removes the element on top of the stack.
	top() -- Get the top element.
	getMin() -- Retrieve the minimum element in the stack.
 */
public class MinStack {
	int num = 0;
	int minValue = Integer.MAX_VALUE;
	Stack<Integer> min = new Stack();
	Stack<Integer> nums = new Stack();
	/** initialize your data structure here. */
	public MinStack() {
	        
	}
	    
	public void push(int x) {
		nums.push(x);
		if(min.isEmpty() || min.peek() >= x){
			min.push(x);
			minValue = x;
		}
	}
	    
	public void pop() {
		
		if(nums.pop()==minValue) {
			min.pop();
			if(!min.empty())
			minValue = min.peek();
			else
				minValue = Integer.MAX_VALUE;
		}
	}
	    
	public int top() {
		return nums.peek();
	}
	    
	public int getMin() {
		return minValue;
	}
}
