package main.java.com.jiang.leetcode100.reverse_linked_list;

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}

class Solution5 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode cur = head;
        while(head.next != null) {
            ListNode next = head.next.next;
            head.next.next = cur;
            cur = head.next;
            head.next = next;
        }
        return cur;
    }
}

public class ReverseLinkedList5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) nums[i] = Integer.parseInt(nums_str[i]);
        ListNode head = new ListNode();
        ListNode cur = head;
        for(int i = 0; i < nums.length; i++) {
            cur.next = new ListNode(nums[i], null);
            cur = cur.next;
        }
        head = head.next;

        ListNode new_head = new Solution5().reverseList(head);
        cur = new_head;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
}