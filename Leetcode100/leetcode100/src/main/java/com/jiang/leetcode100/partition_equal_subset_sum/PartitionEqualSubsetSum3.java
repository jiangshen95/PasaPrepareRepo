package main.java.com.jiang.leetcode100.partition_equal_subset_sum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Solution3 {
    public boolean canPartition(int[] nums) {
        int sumAll = 0;
        for(int num : nums) sumAll += num;
        if((sumAll & 1) != 0) return false;
        int target = (sumAll >> 1);
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for(int i = 0; i < nums.length; i++) {
            for(int j = target; j >= nums[i]; j--) {
                if(dp[target]) return true;
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}

public class PartitionEqualSubsetSum3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums.length; i++) nums[i] = Integer.parseInt(nums_str[i]);

        if(new Solution3().canPartition(nums)) System.out.println("true");
        else System.out.println("false");
    }
}