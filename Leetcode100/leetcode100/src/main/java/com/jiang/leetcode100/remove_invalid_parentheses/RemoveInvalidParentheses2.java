package main.java.com.jiang.leetcode100.remove_invalid_parentheses;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Solution2 {
    private int minremoveCount = Integer.MAX_VALUE;
    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();
        helper(s, 0, 0, 0, new StringBuffer(), 0, set);
        return new ArrayList<>(set);
    }

    private void helper(String s, int index, int leftCount, int rightCount, 
        StringBuffer expression, int removeCount, Set<String> set) {
        
        if(index == s.length()) {
            if(leftCount == rightCount) {
                if(removeCount <= minremoveCount) {
                    String str = expression.toString();
                    if(removeCount < minremoveCount) {
                        minremoveCount = removeCount;
                        set.clear();
                    }
                    System.out.println(str);
                    set.add(str);
                }
            }
        } else {
            char cur = s.charAt(index);
            int length = expression.length();

            if(cur != '(' && cur != ')') {
                expression.append(cur);
                helper(s, index + 1, leftCount, rightCount, expression, removeCount, set);
                expression.deleteCharAt(length);
            } else {
                helper(s, index + 1, leftCount, rightCount, expression, 
                    removeCount + 1, set);
                
                expression.append(cur);
                
                if(cur == '(') {
                    helper(s, index + 1, leftCount + 1, rightCount, expression, 
                        removeCount, set);
                } else if(rightCount < leftCount) {
                    helper(s, index + 1, leftCount, rightCount + 1, expression, 
                        removeCount, set);
                }

                expression.deleteCharAt(length);
            }
        }

    }

}

public class RemoveInvalidParentheses2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        List<String> result = new Solution2().removeInvalidParentheses(s);
        for(String str :result) System.out.println(str);
    }
}