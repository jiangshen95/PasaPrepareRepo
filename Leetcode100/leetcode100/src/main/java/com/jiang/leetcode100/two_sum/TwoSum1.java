package com.jiang.leetcode100.two_sum;

import java.util.Scanner;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}

public class TwoSum1 {
    public static void main(String[] args) {
        int[] nums;

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        nums = new int[n];

        for(int i = 0; i < n; i++) {
            int num = scan.nextInt();
            nums[i] = num;
        }

        int target = scan.nextInt();

        int[] result = new Solution().twoSum(nums, target);
        System.out.printf("%d, %d", result[0], result[1]);
    }
}