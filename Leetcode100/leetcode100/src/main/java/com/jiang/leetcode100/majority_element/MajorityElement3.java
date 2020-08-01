package main.java.com.jiang.leetcode100.majority_element;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution3 {
    public int majorityElement(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int begin, int end) {
        if(begin == end) return nums[begin];
        int mid = begin + (end - begin) / 2;
        int left = helper(nums, begin, mid);
        int right = helper(nums, mid + 1, end);

        if(left == right) return left;

        if(countNumber(nums, begin, end, left) > countNumber(nums, begin, end, right))
            return left;
        else return right;
    }

    private int countNumber(int[] nums, int begin,  int end, int target) {
        int count = 0;
        for(int i = begin; i <= end; i++) {
            if(nums[i] == target) count++;
        }
        return count;
    }
}

public class MajorityElement3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) nums[i] = Integer.parseInt(nums_str[i]);

        System.out.println(new Solution3().majorityElement(nums));
    }
}