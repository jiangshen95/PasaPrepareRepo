package main.java.com.jiang.leetcode100.house_robber;

import java.util.Scanner;

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) dp[i] = nums[i];
            else if(i == 1) dp[i] = Math.max(dp[i - 1], nums[i]);
            else dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}

public class HouseRobber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) nums[i] = Integer.parseInt(nums_str[i]);

        System.out.println(new Solution().rob(nums));
    }
}