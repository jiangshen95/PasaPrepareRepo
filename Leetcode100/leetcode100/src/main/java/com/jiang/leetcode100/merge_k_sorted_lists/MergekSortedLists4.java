package main.java.com.jiang.leetcode100.merge_k_sorted_lists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}

class Solution4 {

    static Comparator<ListNode> nodeComparator = new Comparator<ListNode>(){
        public int compare(ListNode l1, ListNode l2) {
            return l1.val - l2.val;
        }
    };

    public ListNode mergeKLists(ListNode[] lists) {

        Queue<ListNode> priqueue = new PriorityQueue<>(nodeComparator);
        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null) priqueue.add(lists[i]);
        }

        ListNode head = new ListNode();
        ListNode p = head;

        while(!priqueue.isEmpty()) {
            ListNode cur = priqueue.poll();
            p.next = cur;
            p = p.next;

            if(cur.next != null) priqueue.add(cur.next);
        }
        
        return head.next;
    }
}

public class MergekSortedLists4 {
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

        ListNode result = new Solution4().mergeKLists(lists);
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