package main.java.com.jiang.leetcode100.word_break;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

public class WordBreak2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        List<String> wordDict = new ArrayList<>();
        while(!scanner.hasNext("#")) {
            wordDict.add(scanner.next());
        }
        scanner.close();
        
        if(new Solution2().wordBreak(s, wordDict)) System.out.println("true");
        else System.out.println("false");
    }
}