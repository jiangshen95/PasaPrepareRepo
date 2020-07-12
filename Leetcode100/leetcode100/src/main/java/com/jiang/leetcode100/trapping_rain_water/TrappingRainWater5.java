package main.java.com.jiang.leetcode100.trapping_rain_water;

import java.util.Scanner;

class Solution5 {
    public int trap(int[] height) {
        int result = 0;
        int max_left = 0, max_right = 0;
        for(int i = 0; i < height.length; i++) {
            max_left = Math.max(max_left, height[i]);
            max_right = Math.max(max_right, height[height.length - i - 1]);
            result += max_left + max_right - height[i];
        }
        return result - max_left * height.length;
    }
}

public class TrappingRainWater5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] height = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            height[i] = Integer.parseInt(nums_str[i]);
        }

        System.out.println(new Solution5().trap(height));
    }
}