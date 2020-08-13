package main.java.com.jiang.leetcode100.find_all_anagrams_in_a_string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] map = new int[26];
        for(int i = 0; i < p.length(); i++) map[p.charAt(i) - 'a']++;

        List<Integer> result = new ArrayList<>();
        int i = 0;
        while(i < s.length()) {
            while(i < s.length() && map[s.charAt(i) - 'a'] == 0) i++;
            int[] temp = map.clone();
            int count = 0;
            int j = i;
            while(j < s.length() && temp[s.charAt(j) - 'a'] != 0) {
                temp[s.charAt(j) - 'a']--;
                count++;
                j++;
            }
            if(count == p.length())  result.add(i);
            i++;
        }
        return result;
    }
}

public class FindAllAnagramsinaString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String p = scanner.nextLine();
        scanner.close();

        List<Integer> result = new Solution().findAnagrams(s, p);
        for(Integer i : result) {
            System.out.print(i + " ");
        }
    }
}