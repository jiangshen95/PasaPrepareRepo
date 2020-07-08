package main.java.com.jiang.leetcode100.letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution2 {

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

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        String combinations = "";
        dfs(digits, 0, combinations, result);
        return result;
    }

    public void dfs(String digits, int index, String combinations,
        List<String> result) {
        
        if(index == digits.length()) {
            if(!combinations.isEmpty()) result.add(combinations);
            return;
        }

        String cur_chars = mapping[digits.charAt(index) - '2'];
        for(int i = 0; i < cur_chars.length(); i++) {
            dfs(digits, index + 1, combinations + cur_chars.charAt(i), result);
        }

    }
}

public class LetterCombinationsofaPhoneNumber2 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String digits = scanner.nextLine();
        scanner.close();

        List<String> result = new Solution2().letterCombinations(digits);
        for(String s : result) {
            System.out.println(s);
        }
    }

}