package main.java.com.jiang.leetcode100.intersection_of_two_linked_lists;

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while(pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}

public class IntersectionofTwoLinkedLists2 {
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        String str1 = scaner.nextLine();
        String str2 = scaner.nextLine();
        int skipA = scaner.nextInt();
        int skipB = scaner.nextInt();
        scaner.close();

        String[] nums_str1 = str1.split(" ");
        int[] nums1 = new int[nums_str1.length];
        for(int i = 0; i < nums_str1.length; i++) nums1[i] = Integer.parseInt(nums_str1[i]);
        ListNode headA = new ListNode();
        ListNode cur = headA;
        for(int i = 0; i < nums1.length; i++) {
            cur.next = new ListNode(nums1[i]);
            cur = cur.next;
        }
        headA = headA.next;

        cur = headA;
        for(int i = 0; i < skipA; i++) cur = cur.next;

        String[] nums_str2 = str2.split(" ");
        int[] nums2 = new int[nums_str2.length];
        for(int i = 0; i < nums_str2.length; i++) nums2[i] = Integer.parseInt(nums_str2[i]);
        ListNode headB = new ListNode();
        ListNode p = headB;
        for(int i = 0; i < skipB; i++) {
            p.next = new ListNode(nums2[i]);
            p = p.next;
        }
        p.next = cur;
        headB = headB.next;

        ListNode result = new Solution2().getIntersectionNode(headA, headB);
        System.out.println(result.val);
    }
}