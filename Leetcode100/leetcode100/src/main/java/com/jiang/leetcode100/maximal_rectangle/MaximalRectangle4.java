package main.java.com.jiang.leetcode100.maximal_rectangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class Solution4 {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;
        int max_rect = 0;

        int[] left = new int[n];
        int[] right = new int[n];
        int[] heights = new int[n];

        Arrays.fill(right, n);

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '0') heights[j] = 0;
                else heights[j] += 1;
            }

            int cur_left = 0;
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1') left[j] = Math.max(left[j], cur_left);
                else {
                    cur_left = j + 1;
                    left[j] = 0;
                }
            }

            int cur_right = n;
            for(int j = n - 1; j >= 0; j--) {
                if(matrix[i][j] == '1') right[j] = Math.min(right[j], cur_right);
                else {
                    cur_right = j;
                    right[j] = n;
                }
            }

            for(int j = 0; j < n; j++) {
                max_rect = Math.max(max_rect, heights[j] * (right[j] - left[j]));
            }
        }

        return max_rect;
    }
}

public class MaximalRectangle4 {
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

        System.out.println(new Solution4().maximalRectangle(matrix));
    }
}