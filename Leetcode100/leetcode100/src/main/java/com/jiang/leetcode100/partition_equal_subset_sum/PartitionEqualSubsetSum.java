package main.java.com.jiang.leetcode100.partition_equal_subset_sum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public boolean canPartition(int[] nums) {
        int sumAll = 0;
        for(int num : nums) sumAll += num;
        Map<Integer, Boolean> memo = new HashMap<>();
        return helper(nums, 0, sumAll, 0, memo);
    }

    private boolean helper(int[] nums, int index, int sumAll, int sum, 
        Map<Integer, Boolean> memo) {

        if(sumAll - sum == sum) return true;
        if(sumAll - sum < sum) return false;
        if(memo.containsKey(sum)) return memo.get(sum);
        for(int i = index; i < nums.length; i++) {
            if(helper(nums, i + 1, sumAll, sum + nums[i], memo)) {
                memo.put(sum, true);
                return true;
            }
        }
        memo.put(sum, false);
        return false;
    }
}

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums.length; i++) nums[i] = Integer.parseInt(nums_str[i]);

        if(new Solution().canPartition(nums)) System.out.println("true");
        else System.out.println("false");
    }
}