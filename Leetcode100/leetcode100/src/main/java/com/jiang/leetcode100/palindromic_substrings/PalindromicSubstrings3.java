package main.java.com.jiang.leetcode100.palindromic_substrings;

import java.util.Scanner;

class Solution3 {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = s.length();

        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < n; i++) dp[i][i] = true;

        for(int i = n - 1; i >= 0; i--) {
            for(int j = i + 1; j < n; j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    if(j - i == 1) dp[i][j] = true;
                    else dp[i][j] |= dp[i + 1][j - 1];
                    if(dp[i][j]) count++;
                }
            }
        }

        return count;
    }
}

public class PalindromicSubstrings3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        System.out.println(new Solution3().countSubstrings(s));
    }
}