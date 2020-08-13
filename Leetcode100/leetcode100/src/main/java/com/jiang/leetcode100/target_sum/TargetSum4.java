package main.java.com.jiang.leetcode100.target_sum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution4 {
    public int findTargetSumWays(int[] nums, int S) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);
        for(int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> temp = new HashMap<>();
            for(Integer key : dp.keySet()) {
                temp.put(key - nums[i], temp.getOrDefault(key - nums[i], 0) + dp.get(key));
                temp.put(key + nums[i], temp.getOrDefault(key + nums[i], 0) + dp.get(key));
            }
            dp = temp;
        }
        return dp.getOrDefault(S, 0);
    }
}

public class TargetSum4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int S = scanner.nextInt();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums.length; i++) nums[i] = Integer.parseInt(nums_str[i]);

        System.out.println(new Solution4().findTargetSumWays(nums, S));
    }
}