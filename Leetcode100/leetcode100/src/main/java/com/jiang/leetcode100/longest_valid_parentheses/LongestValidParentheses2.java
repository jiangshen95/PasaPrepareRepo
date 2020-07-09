package main.java.com.jiang.leetcode100.longest_valid_parentheses;

import java.util.Scanner;
import java.util.Stack;

class Solution2 {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];
        
        int max_len = 0;
        for(int i = 0; i < n; i++) {
            if(i > 0 && s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
                if(i > 1) dp[i] = dp[i - 2] + 2;
                else dp[i] = 2;
            } else if(i > 0 && s.charAt(i) == ')' && s.charAt(i - 1) == ')') {
                int last_index = i - dp[i - 1] - 1;
                if(last_index >= 0 && s.charAt(last_index) == '(') {
                    dp[i] = dp[i - 1] + 2;
                    if(last_index - 1 >= 0) dp[i] += dp[last_index - 1];
                }
            }
            if(dp[i] > max_len) max_len = dp[i];
        }

        return max_len;
    }
}

public class LongestValidParentheses2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        System.out.println(new Solution2().longestValidParentheses(s));
    }
}