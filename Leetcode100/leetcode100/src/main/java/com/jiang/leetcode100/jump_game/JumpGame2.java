package main.java.com.jiang.leetcode100.jump_game;

import java.util.Scanner;

class Solution2 {
    public boolean canJump(int[] nums) {
        int n = nums.length;

        int position = n - 1;
        while(position > 0) {
            boolean can = false;
            for(int i = 0; i < position; i++) {
                if(nums[i] + i >= position) {
                    can = true;
                    position = i;
                    break;
                }
            }
            if(!can) return false;
        }
        return true;
    }
}

public class JumpGame2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }
        
        if(new Solution2().canJump(nums)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}