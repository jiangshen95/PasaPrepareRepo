package main.java.com.jiang.leetcode100.maximal_square;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int result = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1') {
                    if(i == 0 || j == 0) dp[i][j] = 1;
                    else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), 
                            dp[i - 1][j - 1]) + 1;
                    }
                    if(dp[i][j] > result) result = dp[i][j];
                }
            }
        }
        return result * result;
    }
}

public class MaximalSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();
        while(!scanner.hasNext("#")) {
            inputs.add(scanner.nextLine());
        }
        scanner.close();

        char[][] matrix = new char[inputs.size()][inputs.get(0).length()];
        for(int i = 0; i < inputs.size(); i++) {
            matrix[i] = inputs.get(i).toCharArray();
        }

        System.out.println(new Solution().maximalSquare(matrix));
    }
}