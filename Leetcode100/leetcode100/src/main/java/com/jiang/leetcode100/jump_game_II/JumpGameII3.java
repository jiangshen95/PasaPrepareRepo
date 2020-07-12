package main.java.com.jiang.leetcode100.jump_game_II;

import java.util.Scanner;

class Solution3 {
    public int jump(int[] nums) {
        int n = nums.length;
        int position = n - 1;
        int step = 0;
        while(position > 0) {
            for(int i = 0; i < position; i++) {
                if(nums[i] + i >= position) {
                    position = i;
                    step++;
                    break;
                }
            }
        }
        return step;
    }
}

public class JumpGameII3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }
        System.out.println(new Solution3().jump(nums));
    }
}