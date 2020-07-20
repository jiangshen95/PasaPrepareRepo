package main.java.com.jiang.leetcode100.edit_distance;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

class Solution3 {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();

        int[][] remember = new int[l1 + 1][l2 + 1];
        for(int i = 0; i <= l1; i++) {
            for(int j = 0; j <= l2; j++) remember[i][j] = -1;
        }
        return helper(word1, word2, 0, 0, remember);
    }

    public int helper(String word1, String word2, int i, int j, int[][] remember) {
        if(i == word1.length()) return word2.length() - j;
        if(j == word2.length()) return word1.length() - i;
        if(word1.charAt(i) == word2.charAt(j)) {
            if(remember[i + 1][j + 1] == -1)
                remember[i + 1][j + 1] = helper(word1, word2, i + 1, j + 1, remember);
            return remember[i + 1][j + 1];
        } else {
            if(remember[i][j + 1] == -1) {
                remember[i][j + 1] = helper(word1, word2, i, j + 1, remember);
            }
            if(remember[i + 1][j] == -1) {
                remember[i + 1][j] = helper(word1, word2, i + 1, j, remember);
            }
            if(remember[i + 1][j + 1] == -1) {
                remember[i + 1][j + 1] = helper(word1, word2, i + 1, j + 1, remember);
            }
            return Math.min(Math.min(remember[i][j + 1], remember[i + 1][j]), 
                remember[i + 1][j + 1]) + 1;
        }
    }
}

public class EditDistance3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word1 = scanner.nextLine();
        String word2 = scanner.nextLine();
        scanner.close();
        System.out.println(new Solution3().minDistance(word1, word2));
    }
}