package main.java.com.jiang.leetcode100.remove_invalid_parentheses;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();

        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') stack.push(s.charAt(i));
            else if(s.charAt(i) == ')') {
                if(!stack.isEmpty() && stack.getFirst() == '(') stack.pop();
                else stack.push(s.charAt(i));
            }
        }

        int length = s.length() - stack.size();

        helper(s, set, length);
        return new ArrayList<>(set);
    }

    private void helper(String s, Set<String> set, int length) {
        if(s.length() < length) return;
        if(isValid(s)) {
            set.add(s);
            return;
        }

        for(int i = 0; i < s.length(); i++) {
            if(i > 0 && s.charAt(i) == s.charAt(i - 1)) continue;
            helper(s.substring(0, i) + s.substring(i + 1), set, length);
        }

    }

    private boolean isValid(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') count++;
            else if(s.charAt(i) == ')') count--;
            if(count < 0) return false;
        }
        return count == 0;
    }
}

public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        List<String> result = new Solution().removeInvalidParentheses(s);
        for(String str :result) System.out.println(str);
    }
}