package main.java.com.jiang.leetcode100.sort_colors;

import java.util.Scanner;

class Solution {
    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) red++;
            else if(nums[i] == 1) white++;
            else if(nums[i] == 2) blue++;
        }
        int index = 0;
        for(int i = 0; i < red; i++) nums[index++] = 0;
        for(int i = 0; i < white; i++) nums[index++] = 1;
        for(int i = 0; i < blue; i++) nums[index++] = 2;
    }
}

public class SortColors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }

        new Solution().sortColors(nums);

        for(int i = 0; i < nums.length; i++) System.out.print(nums[i] + " ");
    }
}