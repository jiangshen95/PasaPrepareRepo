package main.java.com.jiang.leetcode100.partition_equal_subset_sum;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution4 {
    public boolean canPartition(int[] nums) {
        int sumAll = 0;
        for(int num : nums) sumAll += num;
        if((sumAll & 1) != 0) return false;
        Arrays.sort(nums);
        int target = sumAll >> 1;
        if(nums[nums.length - 1] > target) return false;
        return helper(nums, nums.length - 1, target);
    }

    private boolean helper(int[] nums, int index, int target) {
        if(target == 0) return true;
        if(target < 0) return false;

        for(int i = index; i >= 0; i--) {
            if(helper(nums, i - 1, target - nums[i])) return true;
        }
        return false;
    }
}

public class PartitionEqualSubsetSum4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums.length; i++) nums[i] = Integer.parseInt(nums_str[i]);

        if(new Solution4().canPartition(nums)) System.out.println("true");
        else System.out.println("false");
    }
}