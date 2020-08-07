package main.java.com.jiang.leetcode100.perfect_squares;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution2 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            int t = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++) {
                t = Math.min(dp[i - j * j], t);
            }
            dp[i] = t + 1;
        }
        return dp[n];
    }
}

public class PerfectSquares2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(new Solution2().numSquares(n));
    }
}