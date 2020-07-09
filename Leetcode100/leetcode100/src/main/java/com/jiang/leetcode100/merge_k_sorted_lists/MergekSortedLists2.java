package main.java.com.jiang.leetcode100.merge_k_sorted_lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}

class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode result = null;
        for(int i = 0; i < lists.length; i++) {
            result = mergeTwoLists(result, lists[i]);
        }
        
        return result;

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode p = head;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        p.next = (l1 == null) ? l2 : l1;
        return head.next;
    }
}

public class MergekSortedLists2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();
        while(!scanner.hasNext("#")) {
            inputs.add(scanner.nextLine());
        }
        scanner.close();
        
        ListNode[] lists = new ListNode[inputs.size()];
        for(int i = 0; i < inputs.size(); i++) {
            ListNode l = new ListNode();
            ListNode p = l;
            String[] nums_str = inputs.get(i).split(" ");
            for(int j = 0; j < nums_str.length; j++) {
                p.next = new ListNode(Integer.parseInt(nums_str[j]));
                p = p.next;
            }
            p.next = null;
            l = l.next;
            lists[i] = l;
        }

        ListNode result = new Solution2().mergeKLists(lists);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }

        // for(int i = 0; i < lists.length; i++) {
        //     ListNode p = lists[i];
        //     while(p != null) {
        //         System.out.print(p.val + " ");
        //         p = p.next;
        //     }
        //     System.out.println("");
        // }
    }
}