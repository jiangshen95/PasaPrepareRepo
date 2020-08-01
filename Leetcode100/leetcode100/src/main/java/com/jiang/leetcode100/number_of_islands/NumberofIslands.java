package main.java.com.jiang.leetcode100.number_of_islands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, visited);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col, boolean[][] visited) {
        visited[row][col] = true;
        int[][] direct = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int i = 0; i < 4; i++) {
            int new_row = row + direct[i][0], new_col = col + direct[i][1];
            if(new_row >= 0 && new_row < grid.length &&
                new_col >= 0 && new_col < grid[0].length &&
                !visited[new_row][new_col] && grid[new_row][new_col] == '1') {
                dfs(grid, new_row, new_col, visited);
            }
        }
    }
}

public class NumberofIslands {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();
        while(!scanner.hasNext("#")) {
            inputs.add(scanner.nextLine());
        }
        scanner.close();

        char[][] grid = new char[inputs.size()][inputs.get(0).length()];
        for(int i = 0; i < inputs.size(); i++) {
            for(int j = 0; j < inputs.get(i).length(); j++) {
                grid[i][j] = inputs.get(i).charAt(j);
            }
        }

        System.out.println(new Solution().numIslands(grid));
    }
}