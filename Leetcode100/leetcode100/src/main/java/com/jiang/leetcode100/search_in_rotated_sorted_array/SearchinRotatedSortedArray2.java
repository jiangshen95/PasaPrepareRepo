package main.java.com.jiang.leetcode100.search_in_rotated_sorted_array;

import java.util.Scanner;

class Solution2 {
    public int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) >> 1;
            System.out.println("mid: " + mid);
            if(nums[mid] == target) return mid;
            if(nums[mid] >= nums[0]) {
                if(nums[mid] > target && target >= nums[0]) right = mid - 1;
                else left = mid + 1;
            } else {
                if(nums[mid] < target && target <= nums[nums.length - 1]) left = mid + 1;
                else right = mid - 1;
            }
        }

        return -1;
    }
}

public class SearchinRotatedSortedArray2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int target = scanner.nextInt();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }
        System.out.println(new Solution2().search(nums, target));
    }
}