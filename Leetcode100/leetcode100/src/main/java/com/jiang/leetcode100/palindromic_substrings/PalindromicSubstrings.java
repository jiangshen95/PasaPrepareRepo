package main.java.com.jiang.leetcode100.palindromic_substrings;

import java.util.Scanner;

class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = s.length();

        for(int i = 0; i < n; i++) {
            for(int j = 1; i + j < n && i - j >= 0; j++) {
                if(s.charAt(i - j) == s.charAt(i + j)) count++;
                else break;
            }
            if(i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                for(int j = 0; i + 1 + j < n && i - j >= 0; j++) {
                    if(s.charAt(i - j) == s.charAt(i + j + 1)) count++;
                    else break;
                }
            }
        }
        return count;
    }
}

public class PalindromicSubstrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        System.out.println(new Solution().countSubstrings(s));
    }
}