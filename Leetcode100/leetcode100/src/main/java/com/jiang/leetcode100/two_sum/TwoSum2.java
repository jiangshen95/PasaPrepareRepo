package main.java.com.jiang.leetcode100.two_sum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if(map.containsKey(other)) {
                return new int[] {map.get(other), i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");

    }
}

public class TwoSum2 {
    public static void main(String[] args) {
        int[] nums;

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        nums = new int[n];

        for(int i = 0; i < n; i++) {
            int num = scan.nextInt();
            nums[i] = num;
        }

        int target = scan.nextInt();

        int[] result = new Solution().twoSum(nums, target);
        System.out.printf("%d, %d", result[0], result[1]);
    }
}