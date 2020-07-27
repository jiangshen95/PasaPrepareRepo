package main.java.com.jiang.leetcode100.copy_list_with_random_pointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.graalvm.compiler.graph.Node;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution4 {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node cur = head;
        while(cur != null) {
            Node clone = new Node(cur.val);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }

        cur = head;
        while(cur != null) {
            if(cur.random != null) cur.next.random = cur.random.next;
            cur = cur.next.next;
        }

        Node new_head = head.next;
        cur = head;
        Node new_cur = new_head;
        while(cur != null) {
            cur.next = cur.next.next;
            new_cur.next = new_cur.next != null ? new_cur.next.next : null;
            cur = cur.next;
            new_cur = new_cur.next;
        }
        return new_head;
    }
}

public class CopyListwithRandomPointer4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) nums[i] = Integer.parseInt(nums_str[i]);
        Node[] nodeList = new Node[nums.length / 2];
        for(int i = 0; i < nums.length; i += 2) {
            nodeList[i / 2] = new Node(nums[i]);
        }

        for(int i = 0; i < nodeList.length; i++) {
            if(i < nodeList.length - 1) nodeList[i].next = nodeList[i + 1];
            if(nums[i * 2 + 1] != -1) nodeList[i].random = nodeList[nums[i * 2 + 1]];
        }

        Node head = new Solution4().copyRandomList(nodeList[0]);
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}