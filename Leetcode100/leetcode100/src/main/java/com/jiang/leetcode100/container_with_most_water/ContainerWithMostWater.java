package main.java.com.jiang.leetcode100.container_with_most_water;

import java.util.Scanner;

/**
 * 双指针算法，难点在于证明双指针的正确性
 * 抛弃的一定都是小的，所以每一步都是安全的
 */
class Solution {
    public int maxArea(int[] height) {
        
        int max_area = 0;

        int begin = 0, end = height.length - 1;
        while(begin < end) {
            int area = (end - begin) * Math.min(height[begin], height[end]);
            max_area = Math.max(max_area, area);
            if(height[begin] > height[end]) {
                end--;
            } else {
                begin++;
            }
        }

        return max_area;

    }
}

public class ContainerWithMostWater {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] str_nums = str.split(" ");
        int[] nums = new int[str_nums.length];
        for(int i = 0; i < str_nums.length; i++) {
            nums[i] = Integer.parseInt(str_nums[i]);
        }

        System.out.println(new Solution().maxArea(nums));
    }

}