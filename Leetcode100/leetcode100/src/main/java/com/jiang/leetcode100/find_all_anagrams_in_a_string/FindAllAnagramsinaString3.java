package main.java.com.jiang.leetcode100.find_all_anagrams_in_a_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution3 {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length()) return new ArrayList<>();
        int[] map = new int[26];
        for(int i = 0; i < p.length(); i++) map[p.charAt(i) - 'a']++;

        List<Integer> result = new ArrayList<>();

        int left = 0, right = 0, count = 0;
        while(right < s.length()) {
            if(map[s.charAt(right) - 'a']-- > 0) {
                count++;
            }
            right++;
            if(count == p.length()) result.add(left);
            if(right - left == p.length()) {
                if(map[s.charAt(left) - 'a'] >= 0) count--;
                map[s.charAt(left) - 'a']++;
                left++;
            }
        }

        return result;
    }
}

public class FindAllAnagramsinaString3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String p = scanner.nextLine();
        scanner.close();

        List<Integer> result = new Solution3().findAnagrams(s, p);
        for(Integer i : result) {
            System.out.print(i + " ");
        }
    }
}