package main.java.com.jiang.leetcode100.shortest_unsorted_continuous_subarray;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

class Solution3 {
    public int findUnsortedSubarray(int[] nums) {

        Deque<Integer> stack = new ArrayDeque<>();
        int left = nums.length, right = 0;

        for(int i = 0; i < nums.length; i++) {
            while(!stack.isEmpty() && nums[i] < nums[stack.getFirst()]) {
                left = Math.min(stack.pop(), left);
            }
            stack.push(i);
        }

        for(int i = nums.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && nums[i] > nums[stack.getFirst()]) {
                right = Math.max(stack.pop(), right);
            }
            stack.push(i);
        }
        return right - left < 0 ? 0 : right - left + 1;
    }
}

public class ShortestUnsortedContinuousSubarray3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }

        System.out.println(new Solution3().findUnsortedSubarray(nums));
    }
}