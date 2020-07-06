package main.java.com.jiang.leetcode100.longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Solution3 {
    public int lengthOfLongestSubstring(String s) {

        int max_len = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0, j = 0; i < s.length(); i++) {
            j = Math.max(j, map.containsKey(s.charAt(i)) ? map.get(s.charAt(i)) : 0);
            max_len = Math.max(max_len, i - j + 1);
            map.put(s.charAt(i), i + 1);
        }
        return max_len;

    }
}

public class LongestSubstringWithoutRepeatingCharacters2 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        System.out.println(new Solution3().lengthOfLongestSubstring(s));
    }

}