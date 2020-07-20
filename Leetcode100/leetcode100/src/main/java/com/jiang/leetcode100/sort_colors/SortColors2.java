package main.java.com.jiang.leetcode100.sort_colors;

import java.util.Scanner;

class Solution2 {
    public void sortColors(int[] nums) {
        int begin = 0, end = nums.length - 1;
        for(int i = 0; i <= end; i++) {
            if(nums[i] == 0) {
                swap(nums, i, begin);
                begin++;
            } else if(nums[i] == 2) {
                swap(nums, i, end);
                i--;
                end--;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}

public class SortColors2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }

        new Solution2().sortColors(nums);

        for(int i = 0; i < nums.length; i++) System.out.print(nums[i] + " ");
    }
}