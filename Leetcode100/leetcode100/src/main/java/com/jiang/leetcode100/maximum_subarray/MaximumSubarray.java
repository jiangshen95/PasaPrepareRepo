package main.java.com.jiang.leetcode100.maximum_subarray;

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, result = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            
            sum += nums[i];
            result = Math.max(result, sum);
            if(sum < 0) sum = 0;
        }
        
        return result;
    }
}

public class MaximumSubarray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }

        System.out.println(new Solution().maxSubArray(nums));
    }
}