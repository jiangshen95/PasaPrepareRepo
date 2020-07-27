package main.java.com.jiang.leetcode100.single_number;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(set.contains(num)) set.remove(num);
            else set.add(num);
        }
        return set.iterator().next();
    }
}

public class SingleNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) nums[i] = Integer.parseInt(nums_str[i]);
        System.out.println(new Solution().singleNumber(nums));
    }
}