package main.java.com.jiang.leetcode100.letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public List<String> letterCombinations(String digits) {
        
        String[] mapping = new String[]{
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };

        List<String> result = new ArrayList<>();
        if(!digits.isEmpty()) result.add("");
        for(int i = 0; i < digits.length(); i++) {
            List<String> temp = new ArrayList<>();
            String cur_chars = mapping[digits.charAt(i) - '2'];
            for(String s : result) {
                for(int j = 0; j < cur_chars.length(); j++) {
                    temp.add(s + cur_chars.charAt(j));
                }
            }
            result.clear();
            result.addAll(temp);
        }

        return result;
    }
}

public class LetterCombinationsofaPhoneNumber {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String digits = scanner.nextLine();
        scanner.close();

        List<String> result = new Solution().letterCombinations(digits);
        for(String s : result) {
            System.out.println(s);
        }
    }

}