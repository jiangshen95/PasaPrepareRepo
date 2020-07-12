package main.java.com.jiang.leetcode100.jump_game_II;

import java.util.Scanner;

class Solution2 {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n < 2) return 0;
        int cur_max = 0, next_max = 0;
        int step = 0;
        int i = 0;
        while(cur_max - i + 1 > 0) {
            step++;
            for(; i <= cur_max; i++) {
                next_max = Math.max(next_max, i + nums[i]);
                if(next_max >= n - 1) return step;
            }
            cur_max = next_max;
        }
        return 0;
    }
}

public class JumpGameII2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }
        System.out.println(new Solution2().jump(nums));
    }
}