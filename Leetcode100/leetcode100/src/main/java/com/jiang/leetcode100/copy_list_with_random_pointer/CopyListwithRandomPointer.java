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

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node new_head = new Node(head.val);
        Node cur = head, p = new_head;
        Map<Node, Node> map = new HashMap<>();
        map.put(cur, p);
        while(cur.next != null) {
            cur = cur.next;
            p.next = new Node(cur.val);
            p = p.next;
            map.put(cur, p);
        }

        cur = head;
        while(cur != null) {
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return new_head;
    }
}

public class CopyListwithRandomPointer {
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

        Node head = new Solution().copyRandomList(nodeList[0]);
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}