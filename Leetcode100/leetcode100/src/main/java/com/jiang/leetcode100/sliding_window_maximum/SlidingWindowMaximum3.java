package main.java.com.jiang.leetcode100.sliding_window_maximum;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution3 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        int[] left = new int[n];
        int[] right = new int[n];

        for(int i = 0; i < n; i++) {
            if(i % k == 0) left[i] = nums[i];
            else {
                left[i] = Math.max(left[i - 1], nums[i]);
            }
            int j = n - i - 1;
            if(j % k == 0 || j == n - 1) right[j] = nums[j];
            else {
                right[j] = Math.max(right[j + 1], nums[j]);
            }
        }

        for(int i = 0; i < n - k + 1; i++) {
            result[i] = Math.max(right[i], left[i + k - 1]);
        }
        
        return result;
    }
}

public class SlidingWindowMaximum3 {
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

        int[] result = new Solution3().maxSlidingWindow(nums, k);
        for(int i = 0; i < result.length; i++) System.out.print(result[i] + " ");
    }
}