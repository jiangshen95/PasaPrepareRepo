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

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode head = new ListNode();
        ListNode p = head;

        while(true) {
            int min_val = Integer.MAX_VALUE;
            int index = -1;
            for(int i = 0; i < lists.length; i++) {
                if(lists[i] != null && lists[i].val < min_val) {
                    min_val = lists[i].val;
                    index = i;
                }
            }
            if(index == -1) break;
            p.next = lists[index];
            p = p.next;
            lists[index] = lists[index].next;
        }
        p.next = null;

        
        return head.next;
    }
}

public class MergekSortedLists {
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

        ListNode result = new Solution().mergeKLists(lists);
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