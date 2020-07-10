package main.java.com.jiang.leetcode100.first_missing_positive;

import java.util.Scanner;

class Solution {
    public int firstMissingPositive(int[] nums) {

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                int t = nums[i];
                nums[i] = nums[t - 1];
                nums[t - 1] = t;
                i--;
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }
}

public class FirstMissingPositive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }

        System.out.println(new Solution().firstMissingPositive(nums));
    }
}