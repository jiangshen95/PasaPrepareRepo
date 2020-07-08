package main.java.com.jiang.leetcode100.remove_Tth_node_from_end_of_list;

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode p = head, q = head;
        int i = 0;
        while(p.next != null) {
            i++;
            if(i > n) q = q.next;
            p = p.next;
        }

        if(q == head && i < n) return head.next;
        if(q.next != null) q.next = q.next.next;

        return head;
    }
}

public class RemoveNthNodeFromEndofList {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int n = scanner.nextInt();
        scanner.close();
        String[] inputs = str.split(" ");

        ListNode head = new ListNode();

        ListNode p = head;
        for(int i = 0; i < inputs.length; i++) {
            p.next = new ListNode(Integer.parseInt(inputs[i]));
            p = p.next;
        }
        p.next = null;
        head = head.next;

        ListNode newHead = new Solution().removeNthFromEnd(head, n);
        while(newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

}