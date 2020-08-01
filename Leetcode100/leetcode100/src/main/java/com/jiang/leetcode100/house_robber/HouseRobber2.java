package main.java.com.jiang.leetcode100.house_robber;

import java.util.Scanner;

class Solution2 {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        int dp0 = nums[0], dp1 = Math.max(dp0, nums[1]);
        for(int i = 2; i < nums.length; i++) {
            int t = Math.max(dp0 + nums[i], dp1);
            dp0 = dp1;
            dp1 = t;
        }
        return dp1;
    }
}

public class HouseRobber2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) nums[i] = Integer.parseInt(nums_str[i]);

        System.out.println(new Solution2().rob(nums));
    }
}