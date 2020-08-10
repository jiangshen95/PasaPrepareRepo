package main.java.com.jiang.leetcode100.remove_invalid_parentheses;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

class Solution4 {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();
        
        set.add(s);
        while(!set.isEmpty()) {
            for(String str : set) {
                if(isValid(str)) result.add(str);
            }
            if(!result.isEmpty()) break;
            Set<String> temp = new HashSet<>();
            for(String str : set) {
                for(int i = 0; i < str.length(); i++) {
                    if(str.charAt(i) == '(' || str.charAt(i) == ')') {
                        temp.add(str.substring(0, i) + str.substring(i + 1));
                    }
                }
            }
            set = temp;
        }

        return result;
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

public class RemoveInvalidParentheses4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        List<String> result = new Solution4().removeInvalidParentheses(s);
        for(String str : result) System.out.println(str);
    }
}