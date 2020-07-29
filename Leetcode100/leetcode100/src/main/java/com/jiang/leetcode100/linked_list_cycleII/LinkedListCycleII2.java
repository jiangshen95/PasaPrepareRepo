package main.java.com.jiang.leetcode100.linked_list_cycleII;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution2 {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }

        if(fast == null || fast.next == null) return null;
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}

public class LinkedListCycleII2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int pos = scanner.nextInt();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }

        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;
        for(int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        if(pos != -1) {
            ListNode p = head;
            for(int i = 0; i < pos; i++) p = p.next;
            cur.next = p;
        }

        ListNode res = new Solution2().detectCycle(head);
        if(res != null) System.out.println(res.val);
        else System.out.println("no cycle");
    }
}