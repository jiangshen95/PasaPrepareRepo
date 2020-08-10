package main.java.com.jiang.leetcode100.find_the_duplicate_number;

import java.util.Scanner;

class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        int low = 1, high = n;
        while(low < high) {
            int mid = low + (high - low) / 2;
            int left = 0, right = 0;
            for(int num : nums) {
                if(num >= low && num <= high) {
                    if(num > mid) right++;
                    else left++;
                }
            }
            if(left > right) high = mid;
            else {
                low = mid + 1;
            }
        }
        return low;
    }
}

public class FindtheDuplicateNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) nums[i] = Integer.parseInt(nums_str[i]);

        System.out.println(new Solution().findDuplicate(nums));
    }
}