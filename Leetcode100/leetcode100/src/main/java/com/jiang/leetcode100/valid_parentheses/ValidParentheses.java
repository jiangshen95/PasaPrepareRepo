package main.java.com.jiang.leetcode100.valid_parentheses;

import java.util.Scanner;
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if(stack.empty()) return false;
                char top = stack.pop();
                if(ch == ')' && top == '(' ||
                    ch == ']' && top == '[' ||
                    ch == '}' && top == '{') {
                    continue;
                }
                return false;
            }
        }

        return stack.empty();
    }
}

public class ValidParentheses {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();

        if(new Solution().isValid(s)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

}