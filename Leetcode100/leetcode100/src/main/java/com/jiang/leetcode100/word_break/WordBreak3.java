package main.java.com.jiang.leetcode100.word_break;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Solution3 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> remember = new HashMap<>();
        return helper(s, wordDict, remember);
    }

    public boolean helper(String s, List<String> wordDict, Map<String, Boolean> remember) {
        if(s.isEmpty()) return true;
        if(remember.containsKey(s)) return remember.get(s);
        boolean result = false;
        for(int i = 0; i < s.length(); i++) {
            if(wordDict.contains(s.substring(0, i + 1))) {
                result |= helper(s.substring(i + 1), wordDict, remember);
            }
        }
        remember.put(s, result);
        return result;
    }
}

public class WordBreak3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        List<String> wordDict = new ArrayList<>();
        while(!scanner.hasNext("#")) {
            wordDict.add(scanner.next());
        }
        scanner.close();
        
        if(new Solution3().wordBreak(s, wordDict)) System.out.println("true");
        else System.out.println("false");
    }
}