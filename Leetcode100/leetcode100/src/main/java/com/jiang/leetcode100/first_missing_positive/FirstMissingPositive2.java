package main.java.com.jiang.leetcode100.first_missing_positive;

import java.util.Scanner;

class Solution2 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(nums[i] <= 0) nums[i] = n + 1;
        }

        for(int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if(num <= n) nums[num - 1] = -Math.abs(nums[num - 1]);
        }

        for(int i = 0; i < n; i++) {
            if(nums[i] > 0) return i + 1;
        }
        return n + 1;
    }
}

public class FirstMissingPositive2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }

        System.out.println(new Solution2().firstMissingPositive(nums));
    }
}