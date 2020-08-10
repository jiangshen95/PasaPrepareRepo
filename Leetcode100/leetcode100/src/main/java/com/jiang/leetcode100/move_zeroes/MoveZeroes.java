package main.java.com.jiang.leetcode100.move_zeroes;

import java.util.Scanner;

class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) nums[index++] = nums[i];
        }
        while(index < nums.length) nums[index++] = 0;
    }
}

public class MoveZeroes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) nums[i] = Integer.parseInt(nums_str[i]);
        new Solution().moveZeroes(nums);
        for(int i = 0; i < nums.length; i++) System.out.print(nums[i] + " ");
    }
}