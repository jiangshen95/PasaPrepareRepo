package main.java.com.jiang.leetcode100.remove_invalid_parentheses;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Solution5 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        helper(s, '(', ')', 0, 0, result);
        return result;
    }

    private void helper(String s, char left, char right, int i_start, int j_start, 
        List<String> result) {

        int count = 0;
        for(int i = i_start; i < s.length(); i++) {
            if(s.charAt(i) == left) count++;
            else if(s.charAt(i) == right) count--;
            if(count < 0) {
                for(int j = j_start; j <= i; j++) {
                    if(s.charAt(j) == right && (j == 0 || s.charAt(j - 1) != right)) {
                        helper(s.substring(0, j) + s.substring(j + 1), left, right, i, j, result);
                    }
                }
                return;
            }
        }
        s = new StringBuffer(s).reverse().toString();
        if(left == '(') {
            helper(s, ')', '(', 0, 0, result);
        } else {
            result.add(s);
        }
    }

}

public class RemoveInvalidParentheses5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        List<String> result = new Solution5().removeInvalidParentheses(s);
        for(String str : result) System.out.println(str);
    }
}