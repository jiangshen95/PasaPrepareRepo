package main.java.com.jiang.leetcode100.reverse_linked_list;

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}

class Solution3 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode new_head = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return new_head;
    }
}

public class ReverseLinkedList3 {
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

        ListNode new_head = new Solution3().reverseList(head);
        cur = new_head;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
}