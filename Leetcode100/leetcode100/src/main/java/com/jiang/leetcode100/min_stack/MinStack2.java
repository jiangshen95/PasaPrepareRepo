package main.java.com.jiang.leetcode100.min_stack;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> min_stack;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min_stack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(min_stack.isEmpty()) min_stack.push(x);
        else if(x <= min_stack.peek()) min_stack.push(x);
    }
    
    public void pop() {
        if(min_stack.peek().equals(stack.pop())) {
            min_stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min_stack.peek();
    }
}