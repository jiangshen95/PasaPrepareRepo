package main.java.com.jiang.leetcode100.decode_string;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

class Solution3 {
    public String decodeString(String s) {

        Deque<String> stack = new ArrayDeque<>();
        Deque<Integer> nums = new ArrayDeque<>();

        StringBuffer result = new StringBuffer();
        int repeat = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '[') {
                stack.push(result.toString());
                nums.push(repeat);
                result = new StringBuffer();
                repeat = 0;
            } else if(s.charAt(i) == ']') {
                int cur_repeat = nums.pop();
                String last_result = stack.pop();
                StringBuffer temp = new StringBuffer();
                temp.append(last_result);
                for(int k = 0; k < cur_repeat; k++) temp.append(result);
                result = temp;
            } else if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                repeat = repeat * 10 + (s.charAt(i) - '0');
            } else {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}

public class DecodeString3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        System.out.println(new Solution3().decodeString(s));
    }
}