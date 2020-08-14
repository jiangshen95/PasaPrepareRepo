package main.java.com.jiang.leetcode100.shortest_unsorted_continuous_subarray;

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int findUnsortedSubarray(int[] nums) {

        int begin = 0;
        while(begin < nums.length - 1 && nums[begin + 1] >= nums[begin]) begin++;
        if(begin == nums.length - 1) return 0;
        int min_after = nums[begin + 1];
        for(int i = begin + 1; i < nums.length; i++) min_after = Math.min(min_after, nums[i]);
        while(begin >= 0 && nums[begin] > min_after) begin--;

        int end = nums.length - 1;
        while(end > 0 && nums[end - 1] <= nums[end]) end--;
        int max_befor = nums[end - 1];
        for(int i = end - 1; i >= 0; i--) max_befor = Math.max(max_befor, nums[i]);
        while(end < nums.length && nums[end] < max_befor) end++;

        return end - begin - 1;
    }
}

public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }

        System.out.println(new Solution().findUnsortedSubarray(nums));
    }
}