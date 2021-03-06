package main.java.com.jiang.leetcode100.add_two_numbers;

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode sum = new ListNode();
        int carry = 0;

        ListNode p = sum;
        while(l1 != null && l2 != null) {
            int num = l1.val + l2.val + carry;
            carry = 0;
            if(num >= 10) {
                num -= 10;
                carry = 1;
            }
            p.next = new ListNode(num);
            p = p.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode l = (l1 == null) ? l2 : l1;
        while(l != null) {
            int num = l.val + carry;
            carry = 0;
            if(num >= 10) {
                num -= 10;
                carry = 1;
            }
            p.next = new ListNode(num);
            p = p.next;

            l = l.next;
        }

        if(carry > 0) {
            p.next = new ListNode(1);
            p = p.next;
        }
        p.next = null;

        return sum.next;
    }
}

public class AddTwoNumbers1 {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        String str2 = scan.nextLine();
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

        ListNode result =  new Solution().addTwoNumbers(l1, l2);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }
}