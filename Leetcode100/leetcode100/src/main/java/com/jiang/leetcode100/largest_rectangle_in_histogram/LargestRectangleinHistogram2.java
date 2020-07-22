package main.java.com.jiang.leetcode100.largest_rectangle_in_histogram;

import java.util.Scanner;
import java.util.Stack;

class Solution2 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if(n == 0) return 0;
        int[] left_less = new int[n];
        int[] right_less = new int[n];

        left_less[0] = -1;
        for(int i = 1; i < n; i++) {
            int k = i - 1;
            while(k >= 0 && heights[k] >= heights[i]) k = left_less[k];
            left_less[i] = k;
        }

        right_less[n - 1] = n;
        for(int i = n - 2; i >= 0; i--) {
            int k = i + 1;
            while(k < n && heights[k] >= heights[i]) k = right_less[k];
            right_less[i] = k;
        }

        int largest_area = 0;
        for(int i = 0; i < n; i++) {
            largest_area = Math.max(largest_area, heights[i] * (right_less[i] - left_less[i] - 1));
        }

        return largest_area;
    }
}

public class LargestRectangleinHistogram2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] heights = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            heights[i] = Integer.parseInt(nums_str[i]);
        }
        
        System.out.println(new Solution2().largestRectangleArea(heights));
    }
}