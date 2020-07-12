package main.java.com.jiang.leetcode100.jump_game_II;

import java.util.Scanner;

/**
 * Time Limit Exceeded
 */
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i = 1; i < n; i++) dp[i] = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(j + nums[j] >= i) dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }
        return dp[n - 1];
    }
}

public class JumpGameII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }
        System.out.println(new Solution().jump(nums));
    }
}