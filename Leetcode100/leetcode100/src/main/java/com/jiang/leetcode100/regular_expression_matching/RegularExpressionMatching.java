package main.java.com.jiang.leetcode100.regular_expression_matching;

import java.util.Scanner;

class Solution {
    public boolean isMatch(String s, String p) {
        System.out.println(s);
        System.out.println(p);

        if(p.isEmpty()) {
            if(s.isEmpty()) return true;
            else return false;
        }

        if(p.length() == 1) {
            if(s.length() != 1) return false;
            if(p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)) return true;
            return false;
        }

        if(p.charAt(1) != '*') {
            if(s.isEmpty()) return false;
            if(s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
                return isMatch(s.substring(1), p.substring(1));
            }
            else return false;
        }
        
        for(int i = -1; i < s.length(); i++) {
            if(i == -1 || p.charAt(0) == '.' || s.charAt(i) == p.charAt(0)) {
                if(isMatch(s.substring(i + 1), p.substring(2))) {
                    return true;
                }
            } else break;
        }
        
        return false;
    }
}

public class RegularExpressionMatching {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String p = scanner.nextLine();
        scanner.close();
        if(new Solution().isMatch(s, p)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}