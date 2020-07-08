package main.java.com.jiang.leetcode100.generate_parentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        if(n == 0) {
            result.add("");
            return result;
        }
        
        for(int i = 0; i < n; i++) {
            for(String left : generateParenthesis(i)) {
                for(String right : generateParenthesis(n - i - 1)) {
                    result.add("(" + left + ")" + right);
                }
            }
        }

        return result;
    }
}

public class GenerateParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        
        List<String> result = new Solution().generateParenthesis(n);
        for(String str : result) {
            System.out.println(str);
        }
    }
}