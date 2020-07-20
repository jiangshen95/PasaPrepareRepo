package main.java.com.jiang.leetcode100.sort_colors;

import java.util.Scanner;

class Solution3 {
    public void sortColors(int[] nums) {
        int l = 0, r = 0;
        for(int i = 0; i < nums.length; i++) {
            int v = nums[i];
            nums[i] = 2;
            if(v < 2) {
                nums[r] = 1;
                r++;
            }
            if(v == 0) nums[l++] = 0;
        }
    }
}

public class SortColors3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }

        new Solution3().sortColors(nums);

        for(int i = 0; i < nums.length; i++) System.out.print(nums[i] + " ");
    }
}