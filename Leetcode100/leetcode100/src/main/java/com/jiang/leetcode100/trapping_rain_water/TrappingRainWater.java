package main.java.com.jiang.leetcode100.trapping_rain_water;

import java.util.Scanner;
import java.util.Stack;

class Solution {
    public int trap(int[] height) {
        int result = 0;
        for(int i = 0; i < height.length; i++) {
            int heightest_left = height[i];
            for(int j = i; j < height.length; j++) {
                heightest_left = Math.max(heightest_left, height[j]);
            }

            int heightest_right = height[i];
            for(int j = i; j >= 0; j--) {
                heightest_right = Math.max(heightest_right, height[j]);
            }
            
            result += Math.min(heightest_left, heightest_right) - height[i];
        }

        return result;
    }
}

public class TrappingRainWater {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] height = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            height[i] = Integer.parseInt(nums_str[i]);
        }

        System.out.println(new Solution().trap(height));
    }
}