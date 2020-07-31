package main.java.com.jiang.leetcode100.min_stack;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import org.graalvm.compiler.graph.Node;

class MinStack {

    class Node {
        int val;
        int min;
        Node next;

        Node() {}
        Node(int val, int min) {
            this.val = val;
            this.min = min;
            this.next = null;
        }
    }

    Node head;
    
    /** initialize your data structure here. */
    public MinStack() {
        head = null;
    }
    
    public void push(int x) {
        if(head == null) head = new Node(x, x);
        else {
            Node node = new Node(x, Math.min(x, head.min));
            node.next = head;
            head = node;
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}