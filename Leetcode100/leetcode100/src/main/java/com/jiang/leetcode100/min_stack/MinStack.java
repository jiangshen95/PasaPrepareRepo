package main.java.com.jiang.leetcode100.min_stack;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

class MinStack {

    private Stack<Integer> stack;
    private Queue<Integer> queue;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        queue = new PriorityQueue<>();
    }
    
    public void push(int x) {
        stack.push(x);
        queue.add(x);
    }
    
    public void pop() {
        int v = stack.pop();
        queue.remove(v);
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return queue.peek();
    }
}