package main.java.com.jiang.leetcode100.longest_valid_parentheses;

import java.util.Scanner;
import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> index_stack = new Stack<>();
        index_stack.push(-1);

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(s.charAt(i));
                index_stack.push(i);
            } else {
                if(!stack.empty() && stack.peek() == '(') {
                    stack.pop();
                    index_stack.pop();
                } else {
                    stack.push(s.charAt(i));
                    index_stack.push(i);
                }
            }
        }

        index_stack.push(s.length());
        int max_len = 0;
        int pre = 0;
        for(Integer x : index_stack) {
            if(x - pre - 1 > max_len) {
                max_len = x - pre - 1;
            }
            pre = x;
        }

        return max_len;
    }
}

public class LongestValidParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        System.out.println(new Solution().longestValidParentheses(s));
    }
}