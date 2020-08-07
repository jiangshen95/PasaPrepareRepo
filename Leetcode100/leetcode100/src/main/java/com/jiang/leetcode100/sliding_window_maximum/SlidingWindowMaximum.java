package main.java.com.jiang.leetcode100.sliding_window_maximum;

import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        int max_num = Integer.MIN_VALUE;
        int index = 0;

        for(int i = 0; i < k; i++) {
            max_num = Math.max(max_num, nums[i]);
        }
        result[index++] = max_num;

        for(int i = k; i < n; i++) {
            if(nums[i] > max_num) {
                max_num = nums[i];
            } else if(nums[i - k] == max_num) {
                max_num = Integer.MIN_VALUE;
                for(int j = i - k + 1; j <= i; j++) max_num = Math.max(nums[j], max_num);
            }
            result[index++] = max_num;
        }

        return result;
    }
}

public class SlidingWindowMaximum {
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

        int[] result = new Solution().maxSlidingWindow(nums, k);
        for(int i = 0; i < result.length; i++) System.out.print(result[i] + " ");
    }
}