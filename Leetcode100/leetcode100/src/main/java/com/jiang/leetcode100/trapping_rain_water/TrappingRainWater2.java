package main.java.com.jiang.leetcode100.trapping_rain_water;

import java.util.Scanner;
import java.util.Stack;

class Solution2 {
    public int trap(int[] height) {
        int result = 0;
        int n = height.length;
        int[] max_left = new int[n];
        int[] max_right = new int[n];

        for(int i = 0; i < n; i++) {
            if(i == 0) max_left[i] = height[i];
            else max_left[i] = Math.max(max_left[i - 1], height[i]);
        }
        for(int i = n - 1; i >= 0; i--) {
            if(i == n - 1) max_right[i] = height[i];
            else max_right[i] = Math.max(max_right[i + 1], height[i]);
        }

        for(int i = 0; i < n; i++)
            result += Math.min(max_left[i], max_right[i]) - height[i];

        return result;
    }
}

public class TrappingRainWater2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] height = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            height[i] = Integer.parseInt(nums_str[i]);
        }

        System.out.println(new Solution2().trap(height));
    }
}