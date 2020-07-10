package main.java.com.jiang.leetcode100.find_first_and_last_position_of_element_in_sorted_array;

import java.util.Scanner;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] result = new int[]{-1, -1};
        if(n <= 0) return result;

        int left = 0, right = n - 1;
        
        while(left <= right) {
            int mid = (left + right) >> 1;
            if(nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        if(left < n && nums[left] == target) result[0] = left;
        else return result;
        right = n - 1;
        while(left <= right) {
            int mid = (left + right) >> 1;
            if(nums[mid] <= target) left = mid + 1;
            else right = mid - 1;
        }
        if(nums[right] == target) result[1] = right;

        return result;
    }
}

public class FindFirstandLastPositionofElementinSortedArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int target = scanner.nextInt();
        scanner.close();;
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }

        int[] result = new Solution().searchRange(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }
}