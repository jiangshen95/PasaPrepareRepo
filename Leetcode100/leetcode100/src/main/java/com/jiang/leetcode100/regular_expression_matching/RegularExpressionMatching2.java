package main.java.com.jiang.leetcode100.regular_expression_matching;

import java.util.Scanner;

/**
 * 动态规划
 */
class Solution2 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for(int i = 0; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(p.charAt(j - 1) != '*') {
                    if( i > 0 && match(s.charAt(i - 1), p.charAt(j - 1))) 
                        dp[i][j] = dp[i - 1][j - 1];
                    else dp[i][j] = false;
                } else {
                    if(i > 0 && match(s.charAt(i - 1), p.charAt(j - 2))) 
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                    else dp[i][j] = dp[i][j - 2];
                }
            }
        }
        return dp[m][n];
    }

    boolean match(char a, char b) {
        return a == b || b == '.';
    }
}

public class RegularExpressionMatching2 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String p = scanner.nextLine();
        scanner.close();
        if(new Solution2().isMatch(s, p)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}