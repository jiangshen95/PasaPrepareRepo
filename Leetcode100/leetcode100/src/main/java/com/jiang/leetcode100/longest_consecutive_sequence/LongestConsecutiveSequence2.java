package main.java.com.jiang.leetcode100.longest_consecutive_sequence;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution2 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) set.add(nums[i]);
        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i] - 1)) {
                int next = nums[i] + 1;
                while(set.contains(next)) next += 1;
                result = Math.max(result, next - nums[i]);
            }
        }
        return result;
    }
}

public class LongestConsecutiveSequence2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }
        System.out.println(new Solution2().longestConsecutive(nums));
    }
}