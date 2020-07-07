package main.java.com.jiang.leetcode100.longest_palindromic_substring;

import java.util.Scanner;

/**
 * 中心扩散
 */
class Solution2 {
    public String longestPalindrome(String s) {
        
        if(s.isEmpty()) return "";

        int max_len = 0;
        String max_palin = "";

        for(int i = 0; i < s.length(); i++) {
            int len1 = centerExpend(s, i, i);
            int len2 = centerExpend(s, i, i + 1);

            if(len1 > max_len) {
                max_len = len1;
                max_palin = s.substring(i - len1 / 2, i + len1 / 2 + 1);
            }
            if(len2 > max_len) {
                max_len = len2;
                max_palin = s.substring(i - len2 / 2 + 1, i + len2 / 2 + 1);
            }
        }

        return max_palin;

    }

    public int centerExpend(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}

public class LongestPalindromicSubstring2 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        scan.close();
        System.out.println(new Solution2().longestPalindrome(s));
    }

}