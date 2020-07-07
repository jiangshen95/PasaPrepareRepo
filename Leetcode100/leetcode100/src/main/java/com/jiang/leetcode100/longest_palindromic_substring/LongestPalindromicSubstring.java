package main.java.com.jiang.leetcode100.longest_palindromic_substring;

import java.util.Scanner;

/**
 * 动态规划
 */
class Solution {
    public String longestPalindrome(String s) {
        
        if(s.isEmpty()) return "";

        int len = s.length();
        int max_len = 0;
        int begin = 0, end = 0;

        int[][] dp = new int[len][len];
        for(int i = 0; i < len; i++) dp[i][i] = 1;

        for(int i = len - 1; i >= 0; i--) {
            for(int j = i + 1; j < len; j++) {

                if(s.charAt(i) == s.charAt(j)) {
                    if(j == i + 1) dp[i][j] = 2;
                    else if(dp[i + 1][j - 1] > 0) dp[i][j] = dp[i + 1][j - 1] + 2;
                    
                    if(dp[i][j] > max_len) {
                        max_len = dp[i][j];
                        begin = i;
                        end = j;
                    }
                }
            }
        }

        System.out.println(begin);
        System.out.println(end);

        return s.substring(begin, end + 1);

    }
}

public class LongestPalindromicSubstring {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        scan.close();
        System.out.println(new Solution().longestPalindrome(s));
    }

}