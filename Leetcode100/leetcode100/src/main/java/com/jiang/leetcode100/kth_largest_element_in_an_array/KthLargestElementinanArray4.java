package main.java.com.jiang.leetcode100.kth_largest_element_in_an_array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

class Solution4 {
    int heapSize;
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k + 1);
        for(int i = 0; i < k; i++) heap.add(nums[i]);
        for(int i = k; i < nums.length; i++) {
            heap.add(nums[i]);
            heap.poll();
        }
        return heap.peek();
    }
}

public class KthLargestElementinanArray4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int k = scanner.nextInt();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) nums[i] = Integer.parseInt(nums_str[i]);

        System.out.println(new Solution4().findKthLargest(nums, k));
    }
}