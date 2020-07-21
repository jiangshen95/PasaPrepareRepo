package main.java.com.jiang.leetcode100.word_search;

import java.util.Scanner;

import sun.tools.jar.resources.jar;

class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(helper(board, i, j, word, 0, visited)) return true;
                }
            }
        }
        return false;
    }

    public boolean helper(char[][] board, int row, int col, 
        String word, int index, boolean[][] visited) {
            int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            if(index == word.length()) return true;
            if(index == word.length() - 1 && word.charAt(index) == board[row][col]) return true;
            if(board[row][col] == word.charAt(index)) {
                System.out.println("row: " + row + " col: " + col + " index: " + index);
                visited[row][col] = true;
                for(int i = 0; i < 4; i++) {
                    System.out.println(row + direction[i][0] + " " + (col + direction[i][1]));
                    if(row + direction[i][0] >= 0 && row + direction[i][0] < visited.length &&
                        col + direction[i][1] >= 0 && col + direction[i][1] < visited[0].length &&
                        !visited[row + direction[i][0]][col + direction[i][1]]) {
                        
                        if(helper(board, row + direction[i][0], col + direction[i][1], 
                            word, index + 1, visited)) return true;
                    }
                }
                visited[row][col] = false;
            }
            return false;
    }
}

public class WordSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] strs = new String[n];
        for(int i = 0; i < n; i++) {
            strs[i] = scanner.next();
        }
        char[][] board = new char[n][strs[0].length()];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < strs[i].length(); j++) {
                board[i][j] = strs[i].charAt(j);
            }
        }
        String word = scanner.next();
        scanner.close();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < board[i].length; j++) System.out.print(board[i][j] + " ");
            System.out.println();
        }
        if(new Solution().exist(board, word)) System.out.println("true");
        else System.out.println("false");
    }
}