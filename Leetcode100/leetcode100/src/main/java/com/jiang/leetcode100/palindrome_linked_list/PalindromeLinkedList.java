package main.java.com.jiang.leetcode100.palindrome_linked_list;

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode slow = head, fast = head;
        ListNode pre = null;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode temp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = temp;
        }
        if(fast != null) slow = slow.next;
        System.out.println("slow: " + slow.val);
        System.out.println("pre: " + pre.val);

        while(pre != null && slow != null) {
            if(pre.val != slow.val) return false;
            slow = slow.next;
            pre = pre.next;
        }

        return slow == pre;

    }
}

public class PalindromeLinkedList {
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

        if(new Solution().isPalindrome(head)) System.out.println("true");
        else System.out.println("false");
    }
}