package main.java.com.jiang.leetcode100.target_sum;

import java.util.Scanner;

class Solution3 {
    public int findTargetSumWays(int[] nums, int S) {
        int[] dp = new int[2001];
        dp[nums[0] + 1000] = 1;
        dp[-nums[0] + 1000] += 1;
        for(int i = 1; i < nums.length; i++) {
            int[] temp = new int[2001];
            for(int j = -1000; j <= 1000; j++) {
                if(dp[j + 1000] > 0) {
                    temp[j + nums[i] + 1000] += dp[j + 1000];
                    temp[j - nums[i] + 1000] += dp[j + 1000];
                }
            }
            dp = temp;
        }
        return S > 1000 ? 0 : dp[S + 1000];
    }
}

public class TargetSum3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int S = scanner.nextInt();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums.length; i++) nums[i] = Integer.parseInt(nums_str[i]);

        System.out.println(new Solution3().findTargetSumWays(nums, S));
    }
}