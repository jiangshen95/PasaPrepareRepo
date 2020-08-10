package main.java.com.jiang.leetcode100.longest_increasing_subsequence;

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int result = 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) nums[i] = Integer.parseInt(nums_str[i]);
        System.out.println(new Solution().lengthOfLIS(nums));
    }
}