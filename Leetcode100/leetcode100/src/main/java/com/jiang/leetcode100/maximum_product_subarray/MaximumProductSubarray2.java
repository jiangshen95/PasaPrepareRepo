package main.java.com.jiang.leetcode100.maximum_product_subarray;

import java.util.Scanner;

class Solution2 {
    public int maxProduct(int[] nums) {
        if(nums.length <= 0) return 0;
        int prefix = 0, suffix = 0;
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            prefix = prefix == 0 ? nums[i] : prefix * nums[i];
            suffix = suffix == 0 ? nums[nums.length - i - 1] : suffix * nums[nums.length - i - 1];
            result = Math.max(Math.max(prefix, suffix), result);
        }
        return result;
    }
}

public class MaximumProductSubarray2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) nums[i] = Integer.parseInt(nums_str[i]);

        System.out.println(new Solution2().maxProduct(nums));
    }
}