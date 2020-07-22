package main.java.com.jiang.leetcode100.maximal_rectangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution2 {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        int max_rect = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1') {
                    if(j == 0) dp[i][j] = 1;
                    else dp[i][j] = dp[i][j - 1] + 1;
                }
                
                int min_len = Integer.MAX_VALUE;
                for(int k = i; k >= 0; k--) {
                    min_len = Math.min(min_len, dp[k][j]);
                    max_rect = Math.max(max_rect, min_len * (i - k + 1));
                }
            }
        }

        return max_rect;
    }
}

public class MaximalRectangle2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();
        while(!scanner.hasNext("#")) {
            inputs.add(scanner.nextLine());
        }
        scanner.close();

        char[][] matrix = new char[inputs.size()][inputs.get(0).length()];
        for(int i = 0; i < inputs.size(); i++) {
            for(int j = 0; j < inputs.get(i).length(); j++) {
                matrix[i][j] = inputs.get(i).charAt(j);
            }
        }

        System.out.println(new Solution2().maximalRectangle(matrix));
    }
}