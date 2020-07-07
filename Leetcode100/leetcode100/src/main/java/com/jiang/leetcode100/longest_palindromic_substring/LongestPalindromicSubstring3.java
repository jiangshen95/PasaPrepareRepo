package main.java.com.jiang.leetcode100.longest_palindromic_substring;

import java.util.Scanner;

/**
 * Manacher 算法
 */
class Solution3 {
    public String longestPalindrome(String s) {
        
        if(s.isEmpty()) return "";

        StringBuffer strbuf = new StringBuffer();
        strbuf.append('#');
        for(int i = 0; i < s.length(); i++) {
            strbuf.append(s.charAt(i));
            strbuf.append('#');
        }

        String s_ex = strbuf.toString();

        int[] arm_lens = new int[s_ex.length()];

        int right = -1, j = -1;
        int begin = 0, end = 0;
        for(int i = 0; i < s_ex.length(); i++) {
            int cur_arm_len;
            if(right >= i) {
                int min_arm_len = Math.min(arm_lens[j * 2 - i], right - i);
                cur_arm_len = centerExpend(s_ex, i - min_arm_len, i + min_arm_len);
            } else {
                cur_arm_len = centerExpend(s_ex, i, i);
            }

            arm_lens[i] = cur_arm_len;
            if(i + cur_arm_len > right) {
                j = i;
                right = i + cur_arm_len;
            }

            if(cur_arm_len * 2 + 1 > end - begin + 1) {
                begin = i - cur_arm_len;
                end = i + cur_arm_len;
            }
        }

        StringBuffer res = new StringBuffer();
        String palin = s_ex.substring(begin, end + 1);
        for(int i = 0; i < palin.length(); i++) {
            if(palin.charAt(i) != '#') res.append(palin.charAt(i));
        }

        return res.toString();

    }

    public int centerExpend(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return (right - left - 1) / 2;
    }
}

public class LongestPalindromicSubstring3 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        scan.close();
        System.out.println(new Solution2().longestPalindrome(s));
    }

}