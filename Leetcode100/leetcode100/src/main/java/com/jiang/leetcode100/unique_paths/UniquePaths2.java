package main.java.com.jiang.leetcode100.unique_paths;

import java.util.Scanner;

class Solution2 {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 0 || j == 0) dp[j] = 1;
                else {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }
        return dp[m - 1];
    }
}

public class UniquePaths2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(new Solution2().uniquePaths(m, n));
    }
}