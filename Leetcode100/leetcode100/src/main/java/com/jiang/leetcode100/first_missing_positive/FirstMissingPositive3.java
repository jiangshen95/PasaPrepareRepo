package main.java.com.jiang.leetcode100.first_missing_positive;

import java.util.Scanner;

class Solution3 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int start = 0, end = n - 1;
        while(start <= end) {
            int num = nums[start] - 1;
            if(num == start) {
                start++;
            } else if(num < 0 || num > end || nums[num] == nums[start]) {
                nums[start] = nums[end--];
            } else {
                nums[start] = nums[num];
                nums[num] = num + 1;
            }
        }
        return start + 1;
    }
}

public class FirstMissingPositive3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }

        System.out.println(new Solution3().firstMissingPositive(nums));
    }
}