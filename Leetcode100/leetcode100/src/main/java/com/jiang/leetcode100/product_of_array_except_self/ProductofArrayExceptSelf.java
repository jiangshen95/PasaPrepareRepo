package main.java.com.jiang.leetcode100.product_of_array_except_self;

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);
        for(int i = 0; i < n; i++) {
            if(i > 0) result[i] = result[i - 1] * nums[i - 1];
        }
        int t = 1;
        for(int i = n - 1; i >= 0; i--) {
            if(i < n - 1) t *= nums[i + 1];
            result[i] = result[i] * t;
        }
        return result;
    }
}

public class ProductofArrayExceptSelf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) nums[i] = Integer.parseInt(nums_str[i]);

        int[] result = new Solution().productExceptSelf(nums);

        for(int num : result) System.out.print(num + " ");
    }
}