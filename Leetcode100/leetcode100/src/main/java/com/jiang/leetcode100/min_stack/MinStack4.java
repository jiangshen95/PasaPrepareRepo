package main.java.com.jiang.leetcode100.min_stack;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

class MinStack {

    private Stack<Long> stack;
    private long min;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = Long.MAX_VALUE;
    }
    
    public void push(int x) {
        if(stack.isEmpty()) {
            min = x;
            stack.push(x - min);
        } else {
            stack.push(x - min);
            if(x < min) min = x;
        }
    }
    
    public void pop() {
        long t = stack.pop();
        if(t < 0) min -= t; 
    }
    
    public int top() {
        long top = stack.peek();
        if(top < 0) return (int) min;
        else return (int) (top + min);
    }
    
    public int getMin() {
        return (int) min;
    }
}