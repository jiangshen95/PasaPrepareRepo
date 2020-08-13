package main.java.com.jiang.leetcode100.find_all_anagrams_in_a_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution2 {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length()) return new ArrayList<>();
        int[] map = new int[26];
        for(int i = 0; i < p.length(); i++) map[p.charAt(i) - 'a']++;

        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0, count = 0;;
        int[] map2 = new int[26];

        while(i < s.length()) {
            if(map2[s.charAt(i) - 'a'] < map[s.charAt(i) - 'a']) {
                map2[s.charAt(i) - 'a']++;
                count++;
                i++;
            } else {
                if(map[s.charAt(i) - 'a'] == 0) {
                    Arrays.fill(map2, 0);
                    j = i + 1;
                    count = 0;
                    i++;
                } else {
                    map2[s.charAt(j) - 'a']--;
                    j++;
                    count--;
                }
            }
            if(count == p.length()) result.add(j);
        }

        return result;
    }
}

public class FindAllAnagramsinaString2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String p = scanner.nextLine();
        scanner.close();

        List<Integer> result = new Solution2().findAnagrams(s, p);
        for(Integer i : result) {
            System.out.print(i + " ");
        }
    }
}