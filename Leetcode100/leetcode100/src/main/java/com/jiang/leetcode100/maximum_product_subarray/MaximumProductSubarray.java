package main.java.com.jiang.leetcode100.maximum_product_subarray;

import java.util.Scanner;

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n <= 0) return 0;
        if(n == 1) return nums[0];
        int result = nums[0];
        int dp_min = nums[0], dp_max = nums[0];
        for(int i = 1; i < n; i++) {
            if(nums[i] < 0) {
                int t = dp_min;
                dp_min = dp_max;
                dp_max = t;
            }

            dp_max = Math.max(dp_max * nums[i], nums[i]);
            dp_min = Math.min(dp_min * nums[i], nums[i]);

            result = Math.max(dp_max, result);
        }
        return result;
    }
}

public class MaximumProductSubarray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) nums[i] = Integer.parseInt(nums_str[i]);

        System.out.println(new Solution().maxProduct(nums));
    }
}