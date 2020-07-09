package main.java.com.jiang.leetcode100.longest_valid_parentheses;

import java.util.Scanner;
import java.util.Stack;

class Solution3 {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int max_len = 0;
        int left = 0, right = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') left++;
            else if(s.charAt(i) == ')') right++;
            if(left == right) max_len = Math.max(max_len, left * 2);
            else if(left < right) {
                left = 0;
                right = 0;
            }
        }

        left = 0;
        right = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == '(') left++;
            else if(s.charAt(i) == ')') right++;
            if(left == right) max_len = Math.max(max_len, left * 2);
            else if(right < left) {
                left = 0;
                right = 0;
            }
        }

        return max_len;
    }
}

public class LongestValidParentheses3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        System.out.println(new Solution3().longestValidParentheses(s));
    }
}