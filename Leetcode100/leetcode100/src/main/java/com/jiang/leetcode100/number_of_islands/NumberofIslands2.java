package main.java.com.jiang.leetcode100.number_of_islands;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Solution2 {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;

        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int row, int col) {
        Queue<Integer> row_queue = new ArrayDeque<>();
        Queue<Integer> col_queue = new ArrayDeque<>();
        row_queue.add(row);
        col_queue.add(col);
        grid[row][col] = '0';
        while(!row_queue.isEmpty()) {
            int i = row_queue.poll();
            int j = col_queue.poll();
            // grid[i][j] = '0';
            if(i > 0 && grid[i - 1][j] == '1') {
                row_queue.add(i - 1);
                col_queue.add(j);
                grid[i - 1][j] = '0';
            }
            if(i < grid.length - 1 && grid[i + 1][j] == '1') {
                row_queue.add(i + 1);
                col_queue.add(j);
                grid[i + 1][j] = '0';
            }
            if(j > 0 && grid[i][j - 1] == '1') {
                row_queue.add(i);
                col_queue.add(j - 1);
                grid[i][j - 1] = '0';
            }
            if(j < grid[0].length - 1 && grid[i][j + 1] == '1') {
                row_queue.add(i);
                col_queue.add(j + 1);
                grid[i][j + 1] = '0';
            }
        }
    }
}

public class NumberofIslands2 {
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

        System.out.println(new Solution2().numIslands(grid));
    }
}