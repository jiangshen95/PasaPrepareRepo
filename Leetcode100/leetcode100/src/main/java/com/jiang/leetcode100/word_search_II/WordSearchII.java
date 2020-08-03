package main.java.com.jiang.leetcode100.word_search_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        for(String word : words) {
            outterloop: for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[i].length; j++) {
                    if(board[i][j] == word.charAt(0)) {
                        boolean[][] visited = new boolean[board.length][board[0].length];
                        if(backtrack(board, i, j, visited, word, 1)) {
                            result.add(word);
                            break outterloop;
                        }
                    }
                }
            }
        }
        return result;
    }

    private boolean backtrack(char[][] board, int i, int j, boolean[][] visited, 
        String word, int index) {

        if(index == word.length()) return true;
        visited[i][j] = true;
        if(i > 0 && !visited[i - 1][j] && board[i - 1][j] == word.charAt(index)) {
            if(backtrack(board, i - 1, j, visited, word, index + 1)) return true;
        }
        if(i < board.length - 1 && !visited[i + 1][j] && board[i + 1][j] == word.charAt(index)) {
            if(backtrack(board, i + 1, j, visited, word, index + 1)) return true;
        }
        if(j > 0 && !visited[i][j - 1] && board[i][j - 1] == word.charAt(index)) {
            if(backtrack(board, i, j - 1, visited, word, index + 1)) return true;
        }
        if(j < board[i].length - 1 && !visited[i][j + 1] && board[i][j + 1] == word.charAt(index)) {
            if(backtrack(board, i, j + 1, visited, word, index + 1)) return true;
        }
        visited[i][j] = false;
        return false;
    }
}

public class WordSearchII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        List<String> inputs = new ArrayList<>();
        while(!scanner.hasNext("#")) {
            inputs.add(scanner.nextLine());
        }
        scanner.nextLine();
        char[][] board = new char[inputs.size()][inputs.get(0).length()];
        for(int i = 0; i < inputs.size(); i++) {
            board[i] = inputs.get(i).toCharArray();
        }

        inputs = new ArrayList<>();
        while(!scanner.hasNext("#")) {
            inputs.add(scanner.nextLine());
        }
        String[] words = new String[inputs.size()];
        inputs.toArray(words);
        scanner.close();

        // for(int i = 0; i < board.length; i++) {
        //     for(int j = 0; j < board[i].length; j++) System.out.print(board[i][j] + " ");
        //     System.out.println();
        // }

        // for(int i = 0; i < words.length; i++) System.out.println(words[i]);

        List<String> result = new Solution().findWords(board, words);
        for(String str : result) System.out.println(str);
    }
}