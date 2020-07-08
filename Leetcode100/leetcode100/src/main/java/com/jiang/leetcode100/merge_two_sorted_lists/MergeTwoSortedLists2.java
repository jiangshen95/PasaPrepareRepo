package main.java.com.jiang.leetcode100.merge_two_sorted_lists;

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}

class Solution2 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}

public class MergeTwoSortedLists2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        String str2 = scan.nextLine();
        scan.close();
        String[] input1 = str1.split(" ");
        String[] input2 = str2.split(" ");

        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();

        ListNode p = l1;
        for(int i = 0; i < input1.length; i++) {
            p.next = new ListNode(Integer.parseInt(input1[i]));
            p = p.next;
        }
        p.next = null;
        l1 = l1.next;

        p = l2;
        for(int i = 0; i < input2.length; i++) {
            p.next = new ListNode(Integer.parseInt(input2[i]));
            p = p.next;
        }
        p.next = null;
        l2 = l2.next;

        ListNode result =  new Solution2().mergeTwoLists(l1, l2);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}