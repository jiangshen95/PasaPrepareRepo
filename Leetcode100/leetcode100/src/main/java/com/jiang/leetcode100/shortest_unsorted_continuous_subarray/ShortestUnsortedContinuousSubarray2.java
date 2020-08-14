package main.java.com.jiang.leetcode100.shortest_unsorted_continuous_subarray;

import java.util.Arrays;
import java.util.Scanner;

class Solution2 {
    public int findUnsortedSubarray(int[] nums) {
        int left = nums.length, right = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] < nums[i]) {
                    right = Math.max(right, j);
                    left = Math.min(left, i);
                }
            }
        }
        return right - left < 0 ? 0 : right - left + 1;
    }
}

public class ShortestUnsortedContinuousSubarray2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }

        System.out.println(new Solution2().findUnsortedSubarray(nums));
    }
}