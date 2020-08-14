package main.java.com.jiang.leetcode100.shortest_unsorted_continuous_subarray;

import java.util.Arrays;
import java.util.Scanner;

class Solution4 {
    public int findUnsortedSubarray(int[] nums) {

        int n = nums.length;
        if(n <= 1) return 0;

        int left = n - 2, right = 1;
        int cur_min = nums[n - 1], cur_max = nums[0];
        int up = 0, down = 1;

        while(left >= 0 && right < n) {
            if(nums[left] > cur_min) down = left;
            else cur_min = nums[left];
            
            if(nums[right] < cur_max) up = right;
            else cur_max = nums[right];

            left--;
            right++;
        }
        return up - down + 1;

    }
}

public class ShortestUnsortedContinuousSubarray4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }

        System.out.println(new Solution4().findUnsortedSubarray(nums));
    }
}