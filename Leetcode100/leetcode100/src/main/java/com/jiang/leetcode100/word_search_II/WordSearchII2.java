package main.java.com.jiang.leetcode100.word_search_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class TrieNode {
    Map<Character, TrieNode> chidren;
    String word;
    TrieNode() {
        chidren = new HashMap<>();
        word = null;
    }
}

class Solution2 {
    public List<String> findWords(char[][] board, String[] words) {

        TrieNode root = new TrieNode();
        for(String word : words) {
            TrieNode cur = root;
            for(int i = 0; i < word.length(); i++) {
                if(!cur.chidren.containsKey(word.charAt(i))) {
                    cur.chidren.put(word.charAt(i), new TrieNode());
                }
                cur = cur.chidren.get(word.charAt(i));
            }
            cur.word = word;
        }

        List<String> result = new ArrayList<>();

        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(root.chidren.containsKey(board[i][j])) {
                    backtrack(board, i, j, root.chidren.get(board[i][j]), result, visited);
                }
            }
        }

        return result;
    }

    private void backtrack(char[][] board, int i, int j, TrieNode cur, List<String> result, 
        boolean[][] visited) {
        visited[i][j] = true;
        if(cur.word != null) {
            result.add(cur.word);
            cur.word = null;
        }
        int[][] offset = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int k = 0; k < 4; k++) {
            int row = i + offset[k][0];
            int col = j + offset[k][1];
            if(row >= 0 && row < board.length && col >= 0 && col < board[0].length &&
                !visited[row][col] && cur.chidren.containsKey(board[row][col])) {
                backtrack(board, row, col, cur.chidren.get(board[row][col]), result, visited);
            }
        }
        visited[i][j] = false;
    }
}

public class WordSearchII2 {
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

        List<String> result = new Solution2().findWords(board, words);
        for(String str : result) System.out.println(str);
    }
}