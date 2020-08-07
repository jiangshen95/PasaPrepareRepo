package main.java.com.jiang.leetcode100.sliding_window_maximum;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        int index = 0;

        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {

            if(!deque.isEmpty() && deque.getFirst() <= i - k) {
                deque.removeFirst();
            }
            while(!deque.isEmpty() && nums[deque.getLast()] < nums[i]) deque.removeLast();
            deque.add(i);
            if(i >= k - 1) result[index++] = nums[deque.getFirst()];
        }

        return result;
    }
}

public class SlidingWindowMaximum2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int k = scanner.nextInt();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }

        int[] result = new Solution2().maxSlidingWindow(nums, k);
        for(int i = 0; i < result.length; i++) System.out.print(result[i] + " ");
    }
}