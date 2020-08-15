package main.java.com.jiang.leetcode100.palindromic_substrings;

import java.util.Scanner;

class Solution4 {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        for(int center = 0; center < 2 * n - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }

        return count;
    }
}

public class PalindromicSubstrings4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        System.out.println(new Solution4().countSubstrings(s));
    }
}