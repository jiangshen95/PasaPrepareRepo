package main.java.com.jiang.leetcode100.remove_invalid_parentheses;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Solution3 {
    public List<String> removeInvalidParentheses(String s) {
        int left = 0, right = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') left++;
            else if(s.charAt(i) == ')') {
                right = left == 0 ? right + 1 : right;
                left = left > 0 ? left - 1 : left;
            }
        }
        Set<String> set = new HashSet<>();
        helper(s, 0, 0, 0, left, right, new StringBuffer(), set);
        return new ArrayList<>(set);
    }

    private void helper(String s, int index, int leftCount, int rightCount,
        int leftRem, int rightRem, 
        StringBuffer expression, Set<String> set) {
        if(index == s.length()) {
            if(leftRem == 0 && rightRem == 0) set.add(expression.toString());
        } else {
            char cur = s.charAt(index);
            int length = expression.length();

            if((cur == '(' && leftRem > 0) || (cur == ')' && rightRem > 0)) {
                helper(s, index + 1, leftCount, rightCount, 
                    leftRem - (cur == '(' ? 1 : 0), rightRem - (cur == ')' ? 1 : 0), 
                    expression, set);
            }
            
            expression.append(cur);

            if(cur != '(' && cur != ')') {
                helper(s, index + 1, leftCount, rightCount, leftRem, rightRem, expression, set);
            } else if(cur == '(') {
                helper(s, index + 1, leftCount + 1, rightCount, leftRem, rightRem, expression, set);
            } else if(leftCount > rightCount) {
                helper(s, index + 1, leftCount, rightCount + 1, leftRem, rightRem, expression, set);
            }
            expression.deleteCharAt(length);
        }

    }

}

public class RemoveInvalidParentheses3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        List<String> result = new Solution3().removeInvalidParentheses(s);
        for(String str : result) System.out.println(str);
    }
}