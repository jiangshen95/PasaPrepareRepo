package main.java.com.jiang.leetcode100.minimum_path_sum;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        int[] dp = new int[n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0) {
                    dp[j] = (j > 0 ? dp[j - 1] : dp[j]) + grid[i][j];
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
                }
            }
        }
        return dp[n - 1];
    }
}

public class MinimumPathSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();
        while(!scanner.hasNext("#")) {
            inputs.add(scanner.nextLine());
        }
        scanner.close();

        int[][] grid = new int[inputs.size()][inputs.get(0).split(" ").length];
        for(int i = 0; i < inputs.size(); i++) {
            String[] line = inputs.get(i).split(" ");
            for(int j = 0; j < line.length; j++) {
                grid[i][j] = Integer.valueOf(line[j]);
            }
        }

        System.out.println(new Solution().minPathSum(grid));
    }
}