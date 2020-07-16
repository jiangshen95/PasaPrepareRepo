package main.java.com.jiang.leetcode100.jump_game;

import java.util.Scanner;

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int max_position = 0;
        int end = 0;
        int i = 0;
        while(end < n - 1 && i <= end) {
            max_position = Math.max(max_position, nums[i] + i);
            if(i == end) end = max_position;
            i++;
        }
        return end >= n - 1;
    }
}

public class JumpGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }
        
        if(new Solution().canJump(nums)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}