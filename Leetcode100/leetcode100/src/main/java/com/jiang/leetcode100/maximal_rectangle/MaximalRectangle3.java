package main.java.com.jiang.leetcode100.maximal_rectangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class Solution3 {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;
        int[] dp = new int[n];

        int max_rect = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '0') dp[j] = 0;
                else {
                    dp[j]++;
                }
            }
            max_rect = Math.max(max_rect, largestRectangleArea(dp));
        }

        return max_rect;
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();

        int largest_area = 0;
        for(int i = 0; i <= heights.length; i++) {
            while(!stack.empty() && (i == heights.length || heights[i] < heights[stack.peek()])) {
                int top = stack.pop();
                int area = 0;
                if(stack.empty()) area = heights[top] * i;
                else area = heights[top] * (i - stack.peek() - 1);
                largest_area = Math.max(largest_area, area);
            }
            stack.push(i);
        }
        return largest_area;
    }
}

public class MaximalRectangle3 {
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

        System.out.println(new Solution3().maximalRectangle(matrix));
    }
}