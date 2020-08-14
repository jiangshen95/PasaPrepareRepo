package main.java.com.jiang.leetcode100.subarray_sum_equals_K;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution2 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        map.put(0, 1);
        int cur_sum = 0;
        for(int i = 0; i < nums.length; i++) {
            cur_sum += nums[i];
            result += map.getOrDefault(cur_sum - k, 0);
            map.put(cur_sum, map.getOrDefault(cur_sum, 0) + 1);
        }
        return result;
    }
}

public class SubarraySumEqualsK2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int k = scanner.nextInt();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }

        System.out.println(new Solution2().subarraySum(nums, k));
    }
}