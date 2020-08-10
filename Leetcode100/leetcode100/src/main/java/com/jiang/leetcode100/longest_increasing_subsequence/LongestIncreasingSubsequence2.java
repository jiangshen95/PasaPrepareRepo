package main.java.com.jiang.leetcode100.longest_increasing_subsequence;

import java.util.Arrays;
import java.util.Scanner;

class Solution2 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int len = 1;
        int[] dp = new int[n + 1];
        dp[len] = nums[0];
        for(int i = 1; i < n; i++) {
            if(nums[i] > dp[len]) {
                dp[++len] = nums[i];
            } else {
                int begin = 1, end = len;
                while(begin <= end) {
                    int mid = begin + (end - begin) / 2;
                    if(dp[mid] >= nums[i]) end = mid - 1;
                    else begin = mid + 1;
                }
                dp[begin] = nums[i];
            }
        }
        return len;
    }
}

public class LongestIncreasingSubsequence2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) nums[i] = Integer.parseInt(nums_str[i]);
        System.out.println(new Solution2().lengthOfLIS(nums));
    }
}