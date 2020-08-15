package main.java.com.jiang.leetcode100.palindromic_substrings;

import java.util.Scanner;

class Solution2 {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        int[] lens = manaches(s);
        for(int i = 0; i < lens.length; i++) {
            count += (lens[i] + 1) / 2;
        }
        return count;
    }

    private int[] manaches(String s) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("@#");
        for(int i = 0; i < s.length(); i++) {
            buffer.append(s.charAt(i));
            buffer.append('#');
        }
        buffer.append("$");
        String s_ex = buffer.toString();
        int[] lens = new int[s_ex.length()];
        int center = 0, right = 0;
        for(int i = 1; i < s_ex.length() - 1; i++) {
            if(i < right) lens[i] = Math.min(right - i, lens[2 * center - i]);
            while(s_ex.charAt(i + lens[i] + 1) == s_ex.charAt(i - lens[i] - 1)) {
                lens[i]++;
            }
            if(i + lens[i] > right) {
                center = i;
                right = i + lens[i];
            }
        }
        return lens;
    }
}

public class PalindromicSubstrings2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        System.out.println(new Solution2().countSubstrings(s));
    }
}