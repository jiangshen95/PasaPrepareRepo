package main.java.com.jiang.leetcode100.longest_consecutive_sequence;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) set.add(nums[i]);
        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                set.remove(nums[i]);
                int pre = nums[i] - 1;
                while(set.contains(pre)) {
                    set.remove(pre);
                    pre = pre - 1;
                }
                int next = nums[i] + 1;
                while(set.contains(next)) {
                    set.remove(next);
                    next += 1;
                }
                result = Math.max(result, next - pre - 1);
            }
        }
        return result;
    }
}

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }
        System.out.println(new Solution().longestConsecutive(nums));
    }
}