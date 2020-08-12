package main.java.com.jiang.leetcode100.partition_equal_subset_sum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Solution2 {
    public boolean canPartition(int[] nums) {
        int sumAll = 0;
        for(int num : nums) sumAll += num;
        if((sumAll & 1) != 0) return false;
        int target = (sumAll >> 1);
        boolean[][] dp = new boolean[nums.length][target + 1];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= target) dp[i][nums[i]] = true;
            for(int j = nums[i] + 1; j <= target; j++) {
                if(i > 0) dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
            }
        }
        return dp[nums.length - 1][target];
    }
}

public class PartitionEqualSubsetSum2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums.length; i++) nums[i] = Integer.parseInt(nums_str[i]);

        if(new Solution2().canPartition(nums)) System.out.println("true");
        else System.out.println("false");
    }
}