package main.java.com.jiang.leetcode100.climbing_stairs;

import java.util.Scanner;

class Solution2 {
    public int climbStairs(int n) {
        int dp0 = 1, dp1 = 1;
        int dp = 1;
        for(int i = 2; i <= n; i++) {
            dp = dp0 + dp1;
            dp0 = dp1;
            dp1 = dp;
        }
        return dp;
    }
}

public class ClimbingStairs2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        scanner.close();
        System.out.println(new Solution2().climbStairs(n));
    }
}