package main.java.com.jiang.leetcode100.search_in_rotated_sorted_array;

import java.util.Scanner;

class Solution {
    public int search(int[] nums, int target) {
        if(nums.length <= 0) return -1;
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) >> 1;
            if(nums[mid] > nums[nums.length - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(left);

        int res = -1;
        if(target > nums[nums.length - 1]) {
            res = binarySearch(nums, 0, left - 1, target);
        } else {
            res = binarySearch(nums, left, nums.length - 1, target);
        }

        if(res != -1 && nums[res] == target) return res;
        else return -1;
    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        System.out.println("left: " + left);
        System.out.println("right: " + right);
        if(left > right) return -1;
        int l = left, r = right;
        while(l <= r) {
            int m = (l + r) >> 1;
            if(nums[m] >= target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        System.out.println("l: " + l);
        return l;
    }
}

public class SearchinRotatedSortedArray {
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
        System.out.println(new Solution().search(nums, target));
    }
}