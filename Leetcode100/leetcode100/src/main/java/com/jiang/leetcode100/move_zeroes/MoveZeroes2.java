package main.java.com.jiang.leetcode100.move_zeroes;

import java.util.Arrays;
import java.util.Scanner;

class Solution2 {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int t = nums[i];
                nums[i] = nums[index];
                nums[index] = t;
                index++;
            }
        }
    }
}

public class MoveZeroes2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) nums[i] = Integer.parseInt(nums_str[i]);
        new Solution2().moveZeroes(nums);
        for(int i = 0; i < nums.length; i++) System.out.print(nums[i] + " ");
    }
}