package main.java.com.jiang.leetcode100.trapping_rain_water;

import java.util.Scanner;
import java.util.Stack;

class Solution3 {
    public int trap(int[] height) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < height.length; i++) {
            if(stack.isEmpty() || height[i] <= height[stack.peek()]) stack.push(i);
            else {
                while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int top = stack.pop();
                    if(stack.empty()) break;
                    result += (Math.min(height[i], height[stack.peek()]) - height[top]) *
                        (i - stack.peek() - 1);
                }
                stack.push(i);
            }
        }
        return result;
    }
}

public class TrappingRainWater3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] height = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            height[i] = Integer.parseInt(nums_str[i]);
        }

        System.out.println(new Solution3().trap(height));
    }
}