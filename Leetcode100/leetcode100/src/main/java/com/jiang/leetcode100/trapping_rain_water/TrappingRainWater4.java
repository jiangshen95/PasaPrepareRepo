package main.java.com.jiang.leetcode100.trapping_rain_water;

import java.util.Scanner;

class Solution4 {
    public int trap(int[] height) {
        int result = 0;
        int max_left = 0, max_right = 0;
        int left = 0, right = height.length - 1;
        while(left < right) {
            if(height[left] < height[right]) {
                max_left = Math.max(max_left, height[left]);
                result += max_left - height[left];
                left++;
            } else {
                max_right = Math.max(max_right, height[right]);
                result += max_right - height[right];
                right--;
            }
        }
        return result;
    }
}

public class TrappingRainWater4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] height = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            height[i] = Integer.parseInt(nums_str[i]);
        }

        System.out.println(new Solution4().trap(height));
    }
}