package main.java.com.jiang.leetcode100.kth_largest_element_in_an_array;

import java.util.Scanner;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k);
    }

    private int findKthLargest(int[] nums, int begin, int end, int k) {
        if(begin >= end) return nums[begin];
        int v = nums[begin];
        int i = begin, j = end;
        while(i < j) {
            while(i < j && nums[j] <= v) j--;
            nums[i] = nums[j];
            while(i < j && nums[i] >= v) i++;
            nums[j] = nums[i];
        }
        nums[i] = v;
        if(i + 1 == k) return nums[i];
        if(i < k) return findKthLargest(nums, i + 1, end, k);
        else return findKthLargest(nums, begin, i - 1, k);
    }
}

public class KthLargestElementinanArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int k = scanner.nextInt();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) nums[i] = Integer.parseInt(nums_str[i]);

        System.out.println(new Solution().findKthLargest(nums, k));
    }
}