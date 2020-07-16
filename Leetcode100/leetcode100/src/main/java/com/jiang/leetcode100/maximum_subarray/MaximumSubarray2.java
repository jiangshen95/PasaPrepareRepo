package main.java.com.jiang.leetcode100.maximum_subarray;

import java.util.Arrays;
import java.util.Scanner;

class Solution2 {
    public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public int helper(int[] nums, int left, int right) {
        if(left >= right) return nums[left];
        int mid = (left + right) >> 1;
        int lmax = helper(nums, left, mid - 1);
        int rmax = helper(nums, mid + 1, right);
        int sum = nums[mid], t = nums[mid];
        for(int i = mid + 1; i <= right; i++) {
            t += nums[i];
            sum = Math.max(sum, t);
        }
        t = sum;
        for(int i = mid - 1; i >= left; i--) {
            t += nums[i];
            sum = Math.max(sum, t);
        }
        return Math.max(Math.max(lmax, rmax), sum);
    }
}

public class MaximumSubarray2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }

        System.out.println(new Solution2().maxSubArray(nums));
    }
}