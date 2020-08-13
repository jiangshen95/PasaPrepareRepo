package main.java.com.jiang.leetcode100.target_sum;

import java.util.Scanner;

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        return helper(nums, 0, S);
    }

    private int helper(int[] nums, int index, int target) {
        if(index == nums.length && target == 0) return 1;
        if(index == nums.length) return 0;
        return helper(nums, index + 1, target - nums[index]) + 
            helper(nums, index + 1, target + nums[index]);
    }
}

public class TargetSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int S = scanner.nextInt();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums.length; i++) nums[i] = Integer.parseInt(nums_str[i]);

        System.out.println(new Solution().findTargetSumWays(nums, S));
    }
}