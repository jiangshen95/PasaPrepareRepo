package main.java.com.jiang.leetcode100.subarray_sum_equals_K;

import java.util.Scanner;

class Solution {
    public int subarraySum(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++) helper(nums, i, 0, k);
        return result;
    }

    private int result = 0;
    private void helper(int[] nums, int index, int sum, int k) {
        if(index == nums.length) return;
        if(sum + nums[index] == k) result++;
        helper(nums, index + 1, sum + nums[index], k);
    }
}

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int k = scanner.nextInt();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }

        System.out.println(new Solution().subarraySum(nums, k));
    }
}