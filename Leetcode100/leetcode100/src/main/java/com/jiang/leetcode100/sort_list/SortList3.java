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

class Solution3 {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode cur = head;
        int length = 0;
        while(cur != null) {
            length++;
            cur = cur.next;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;

        for(int step = 1; step < length; step <<= 1) {
            ListNode left = dummy.next;
            cur = dummy;
            while(left != null) {
                ListNode right = split(left, step);
                ListNode t = split(right, step);
                cur = merge(left, right, cur);
                left = t;
            }
        }
        return dummy.next;
    }

    private ListNode split(ListNode cur, int step) {
        ListNode pre = cur;
        for(int i = 0; i < step; i++) {
            pre = cur;
            if(cur != null) cur = cur.next;
        }
        if(pre != null) pre.next = null;
        return cur;
    }

    private ListNode merge(ListNode l1, ListNode l2, ListNode cur) {
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        while(cur.next != null) cur = cur.next;
        return cur;
    }
}

public class SortList3 {
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

        ListNode new_head = new Solution3().sortList(head);
        cur = new_head;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
}