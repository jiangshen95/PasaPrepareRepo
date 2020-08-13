package main.java.com.jiang.leetcode100.target_sum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution5 {
    public int findTargetSumWays(int[] nums, int S) {
        int sumAll = 0;
        for(int num : nums) sumAll += num;
        if(sumAll < S || ((sumAll + S) & 1) == 1) return 0;
        return subsetSum(nums, (sumAll + S) >> 1);
    }

    private int subsetSum(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int num : nums) {
            for(int i = target; i >= num; i--) dp[i] += dp[i - num];
        }
        return dp[target];
    }
}

public class TargetSum5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int S = scanner.nextInt();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums.length; i++) nums[i] = Integer.parseInt(nums_str[i]);

        System.out.println(new Solution5().findTargetSumWays(nums, S));
    }
}