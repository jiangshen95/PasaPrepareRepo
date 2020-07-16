package main.java.com.jiang.leetcode100.maximum_subarray;

import java.util.Arrays;
import java.util.Scanner;

class Solution3 {
    public int maxSubArray(int[] nums) {
        int pre = 0, result = nums[0];
        for(int i = 0; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            result = Math.max(result, pre);
        }
        
        return result;
    }
}

public class MaximumSubarray3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }

        System.out.println(new Solution3().maxSubArray(nums));
    }
}