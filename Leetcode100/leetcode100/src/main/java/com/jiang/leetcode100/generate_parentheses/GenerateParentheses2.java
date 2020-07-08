package main.java.com.jiang.leetcode100.generate_parentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution2 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        generateParenthesis(n, n, "", result);

        return result;
    }

    public void generateParenthesis(int n, int m, String parenth, List<String> result) {
        if(n == m && n == 0) {
            result.add(parenth);
            return;
        }

        if(n > 0) generateParenthesis(n - 1, m, parenth + '(', result);
        if(n < m) generateParenthesis(n, m - 1, parenth + ')', result);
    }
}

public class GenerateParentheses2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        
        List<String> result = new Solution2().generateParenthesis(n);
        for(String str : result) {
            System.out.println(str);
        }
    }
}