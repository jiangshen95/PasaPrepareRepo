package main.java.com.jiang.leetcode100.longest_substring_without_repeating_characters;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution2 {
    public int lengthOfLongestSubstring(String s) {

        int[] index = new int[128];
        int max_len = 0;
        for(int i = 0, j = 0; j < s.length(); j++) {
            i = Math.max(i, index[s.charAt(j)]);
            
            // 这里的 j + 1 与 j - i + 1 使串的长度为 1 时也能符合，不需要单独讨论
            max_len = Math.max(max_len, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return max_len;
    }
}

public class LongestSubstringWithoutRepeatingCharacters2 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        System.out.println(new Solution2().lengthOfLongestSubstring(s));
    }

}