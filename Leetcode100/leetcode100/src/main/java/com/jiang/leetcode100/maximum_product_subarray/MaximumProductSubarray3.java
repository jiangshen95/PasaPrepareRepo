package main.java.com.jiang.leetcode100.maximum_product_subarray;

import java.util.Scanner;

class Solution3 {
    public int maxProduct(int[] nums) {
        if(nums.length <= 0) return 0;
        int max_neg = Integer.MIN_VALUE;
        int cur = 1;
        int result = Integer.MIN_VALUE;
        for(int num : nums) {
            cur *= num;
            if(cur > 0) {
                result = Math.max(result, cur);
            } else if(cur < 0) {
                if(max_neg != Integer.MIN_VALUE) result = Math.max(result, cur / max_neg);
                else result = Math.max(result, num);
                max_neg = Math.max(max_neg, cur);
            } else {
                max_neg = Integer.MIN_VALUE;
                result = Math.max(result, cur);
                cur = 1;
            }
        }
        return result;
    }
}

public class MaximumProductSubarray3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) nums[i] = Integer.parseInt(nums_str[i]);

        System.out.println(new Solution3().maxProduct(nums));
    }
}