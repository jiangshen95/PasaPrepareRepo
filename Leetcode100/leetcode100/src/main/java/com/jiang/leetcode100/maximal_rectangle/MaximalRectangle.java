package main.java.com.jiang.leetcode100.maximal_rectangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;
        int max_rect = 0;
        for(int i = 0; i < m; i++) {
            for(int j = i; j < m; j++) {
                max_rect = Math.max(getMaxRectByLine(matrix, n, i, j), max_rect);
            }
        }
        return max_rect;
    }

    public int getMaxRectByLine(char[][] matrix, int n, int begin, int end) {
        char[] flag = new char[n];
        Arrays.fill(flag, '1');
        for(int i = begin; i <= end; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1' && flag[j] == '1') flag[j] = '1';
                else flag[j] = '0';
            }
        }

        int max_len = 0;
        int len = 0;
        for(int i = 0; i < n; i++) {
            if(flag[i] == '1') len++;
            else {
                max_len = Math.max(max_len, len);
                len = 0;
            }
        }
        max_len = Math.max(max_len, len);
        return max_len * (end - begin + 1);
    }
}

public class MaximalRectangle {
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

        System.out.println(new Solution().maximalRectangle(matrix));
    }
}