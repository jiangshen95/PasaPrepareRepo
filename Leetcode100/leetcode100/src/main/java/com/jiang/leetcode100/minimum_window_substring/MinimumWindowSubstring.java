package main.java.com.jiang.leetcode100.minimum_window_substring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public String minWindow(String s, String t) {

        int[] tmap = new int[256];
        for(int i = 0; i < t.length(); i++) tmap[t.charAt(i)]++;

        int[] smap = new int[256];

        int begin = 0, end = 0;
        int hasfound = 0;
        int min_size = Integer.MAX_VALUE;
        String result = "";
        while(end < s.length()) {
            smap[s.charAt(end)]++;
            if(smap[s.charAt(end)] <= tmap[s.charAt(end)]) hasfound++;
            if(hasfound == t.length() && tmap[s.charAt(end)] > 0) {
                while(smap[s.charAt(begin)] > tmap[s.charAt(begin)]) {
                    smap[s.charAt(begin)]--;
                    begin++;
                }
                if(end - begin + 1 < min_size) {
                    min_size = end - begin + 1;
                    result = s.substring(begin, end + 1);
                }
            }
            end++;
        }

        return result;
    }
}

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        scanner.close();
        System.out.println(new Solution().minWindow(s, t));
    }
}