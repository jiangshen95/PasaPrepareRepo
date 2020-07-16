package main.java.com.jiang.leetcode100.jump_game;

import java.util.Scanner;

class Solution3 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int last_position = n - 1;
        for(int i = n - 1; i >= 0; i--) {
            if(nums[i] + i >= last_position) last_position = i;
        }
        return last_position == 0;
    }
}

public class JumpGame3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }
        
        if(new Solution3().canJump(nums)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}