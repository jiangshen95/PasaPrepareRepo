package main.java.com.jiang.leetcode100.minimum_path_sum;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

class Solution2 {
    public int minPathSum(int[][] grid) {
        return helper(grid, 0, 0);
    }

    public int helper(int[][] grid, int i, int j) {
        if(i >= grid.length || j >= grid[0].length) return Integer.MAX_VALUE;
        if(i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];
        return grid[i][j] + Math.min(helper(grid, i + 1, j), helper(grid, i, j + 1));
    }
}

public class MinimumPathSum2 {
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

        System.out.println(new Solution2().minPathSum(grid));
    }
}