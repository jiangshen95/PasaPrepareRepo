package main.java.com.jiang.leetcode100.longest_substring_without_repeating_characters;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.isEmpty()) return 0;
        
        int max_length = 1;

        int begin = 0;
        int end = begin + 1;

        Set<Character> set = new HashSet<>();
        set.add(s.charAt(begin));

        while(end < s.length()) {
            if(set.contains(s.charAt(end))) {
                max_length = Math.max(max_length, end - begin);
                set.remove(s.charAt(begin));
                begin++;
            } else {
                set.add(s.charAt(end));
                end++;
            }
        }

        max_length = Math.max(max_length, end - begin);

        return max_length;
    }
}

public class LongestSubstringWithoutRepeatingCharacters {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        System.out.println(new Solution().lengthOfLongestSubstring(s));
    }

}