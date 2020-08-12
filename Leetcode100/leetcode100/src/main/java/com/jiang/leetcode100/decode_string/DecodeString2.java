package main.java.com.jiang.leetcode100.decode_string;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

class Solution2 {
    public String decodeString(String s) {

        Deque<String> stack = new ArrayDeque<>();
        Deque<Integer> nums = new ArrayDeque<>();

        int i = 0;
        while(i < s.length()) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int v = 0;
                while(s.charAt(i) >='0' && s.charAt(i) <= '9') {
                    v = v * 10 + (s.charAt(i) - '0');
                    i++;
                }
                nums.push(v);
            } else if(s.charAt(i) == '[' || s.charAt(i) != ']') {
                stack.push(s.substring(i, i + 1));
                i++;
            } else {
                List<String> sub = new ArrayList<>();
                while(!stack.getFirst().equals("[")) {
                    sub.add(stack.pop());
                }
                stack.pop();
                Collections.reverse(sub);
                StringBuffer buffer = new StringBuffer();
                for(String str : sub) buffer.append(str);

                StringBuffer sb = new StringBuffer();
                int repeat = nums.pop();
                for(int k = 0; k < repeat; k++) sb.append(buffer);

                stack.push(sb.toString());
                i++;
            }
        }

        StringBuffer result = new StringBuffer();
        while(!stack.isEmpty()) {
            result.append(stack.pollLast());
        }

        return result.toString();
    }
}

public class DecodeString2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        System.out.println(new Solution2().decodeString(s));
    }
}