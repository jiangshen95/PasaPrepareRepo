package main.java.com.jiang.leetcode100.jump_game_II;

import java.util.Scanner;

class Solution4 {
    public int jump(int[] nums) {
        int n = nums.length;
        int max_position = 0;
        int step = 0;
        int end = 0;
        int i = 0;
        while(end < n - 1) {
            max_position = Math.max(max_position, nums[i] + i);
            if(i == end) {
                step++;
                end = max_position;
            }
            i++;
        }
        
        return step;
    }
}

public class JumpGameII4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }
        System.out.println(new Solution4().jump(nums));
    }
}