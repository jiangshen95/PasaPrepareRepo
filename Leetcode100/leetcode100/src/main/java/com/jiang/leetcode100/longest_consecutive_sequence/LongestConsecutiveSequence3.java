package main.java.com.jiang.leetcode100.longest_consecutive_sequence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Solution3 {
    public int longestConsecutive(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                int left = map.getOrDefault(nums[i] - 1, 0);
                int right = map.getOrDefault(nums[i] + 1, 0);
                int cur_length = left + right + 1;
                result = Math.max(result, cur_length);
                map.put(nums[i], cur_length);
                map.put(nums[i] - left, cur_length);
                map.put(nums[i] + right, cur_length);
            }
        }
        return result;
    }
}

public class LongestConsecutiveSequence3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }
        System.out.println(new Solution3().longestConsecutive(nums));
    }
}