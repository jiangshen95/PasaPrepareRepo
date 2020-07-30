package main.java.com.jiang.leetcode100.sort_list;

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode pre = cur;
        int v = head.val;
        ListNode left = new ListNode();
        ListNode p = left;
        while(cur != null) {
            if(cur.val < v) {
                p.next = cur;
                pre.next = cur.next;
                p = p.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        p.next = null;
        left =  sortList(left.next);
        head.next = sortList(head.next);
        if(left == null) return head;
        cur = left;
        while(cur.next != null) cur = cur.next;
        cur.next = head;
        return left;
    }
}

public class SortList {
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

        ListNode new_head = new Solution().sortList(head);
        cur = new_head;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
}