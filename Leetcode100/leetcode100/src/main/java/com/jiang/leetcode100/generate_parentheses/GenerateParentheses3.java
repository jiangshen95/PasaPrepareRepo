package main.java.com.jiang.leetcode100.generate_parentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 动态规划算法
 */
class Solution3 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        if(n == 0) {
            return result;
        }

        List<List<String>> dp = new ArrayList<>();
        
        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);
        
        for(int i = 1; i <= n; i++) {
            List<String> cur = new ArrayList<>();
            for(int j = 0; j < i; j++) {
                for(String left : dp.get(j)) {
                    for(String right : dp.get(i - j - 1)) {
                        cur.add("(" + left + ")" + right);
                    }
                }
            }
            dp.add(cur);
        }

        return dp.get(n);
    }
}

public class GenerateParentheses3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        
        List<String> result = new Solution3().generateParenthesis(n);
        for(String str : result) {
            System.out.println(str);
        }
    }
}