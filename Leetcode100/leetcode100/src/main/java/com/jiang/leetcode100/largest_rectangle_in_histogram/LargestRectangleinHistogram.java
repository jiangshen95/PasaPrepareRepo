package com.jiang.leetcode100.largest_rectangle_in_histogram;

import java.util.Scanner;
import java.util.Stack;

class Solution {
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

public class LargestRectangleinHistogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] heights = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            heights[i] = Integer.parseInt(nums_str[i]);
        }
        
        System.out.println(new Solution().largestRectangleArea(heights));
    }
}