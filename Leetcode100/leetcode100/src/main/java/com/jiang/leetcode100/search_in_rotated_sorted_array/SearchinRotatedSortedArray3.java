package main.java.com.jiang.leetcode100.search_in_rotated_sorted_array;

import java.util.Scanner;

class Solution3 {
    public int search(int[] nums, int target) {
        if(nums.length <= 0) return -1;
        int n = nums.length;
        int left = 0, right = n - 1;
        while(left <= right) {
            int mid = (left + right) >> 1;
            if(nums[mid] > nums[n - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        int rot = left;

        System.out.println("rot: " + rot);

        int l = 0, r = n - 1;
        while(l <= r) {
            int m = (l + r) >> 1;
            int realm = (m + rot) % n;
            System.out.println("realm: " + realm);
            if(nums[realm] == target) return realm;
            if(nums[realm] < target) l = m + 1;
            else r = m - 1;
        }

        return -1;
    }
}

public class SearchinRotatedSortedArray3 {
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
        System.out.println(new Solution3().search(nums, target));
    }
}