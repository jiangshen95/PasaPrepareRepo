package main.java.com.jiang.leetcode100.subarray_sum_equals_K;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution3 {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum += nums[j];
                if(sum == k) result++;
            }
        }
        return result;
    }
}

public class SubarraySumEqualsK3 {
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

        System.out.println(new Solution3().subarraySum(nums, k));
    }
}