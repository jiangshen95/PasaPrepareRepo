package main.java.com.jiang.leetcode100.word_break;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];

        int i = -1;
        while(i < s.length()) {
            while(i >= 0 && i < s.length() && !dp[i]) i++;
            for(int j = i + 1; j < s.length(); j++) {
                if(wordDict.contains(s.substring(i + 1, j + 1))) {
                    dp[j] = true;
                }
            }
            i++;
        }

        return dp[s.length() - 1];
    }
}

public class WordBreak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        List<String> wordDict = new ArrayList<>();
        while(!scanner.hasNext("#")) {
            wordDict.add(scanner.next());
        }
        scanner.close();
        
        if(new Solution().wordBreak(s, wordDict)) System.out.println("true");
        else System.out.println("false");
    }
}