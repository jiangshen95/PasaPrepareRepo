package main.java.com.jiang.leetcode100.decode_string;

import java.util.Scanner;

class Solution {
    public String decodeString(String s) {
        StringBuffer buffer = new StringBuffer();
        int i = 0;
        while(i < s.length()) {
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9') {
                int v = 0;
                while(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    v = v * 10 + (s.charAt(i) - '0');
                    i++;
                }
                int begin = i;
                int count = 0;
                while(i < s.length()) {
                    if(s.charAt(i) == '[') count++;
                    else if(s.charAt(i) == ']') count--;
                    if(count == 0) break;
                    i++;
                }

                String torepead = decodeString(s.substring(begin + 1, i));
                for(int k = 0; k < v; k++) buffer.append(torepead);
                i++;
            } else {
                buffer.append(s.charAt(i));
                i++;
            }
        }
        return buffer.toString();
    }
}

public class DecodeString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        System.out.println(new Solution().decodeString(s));
    }
}