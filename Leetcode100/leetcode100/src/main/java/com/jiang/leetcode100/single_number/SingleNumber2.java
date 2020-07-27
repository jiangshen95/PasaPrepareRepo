package main.java.com.jiang.leetcode100.single_number;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution2 {
    public int singleNumber(int[] nums) {
        int a = 0;
        for(int num : nums) a ^= num;
        return a;
    }
}

public class SingleNumber2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) nums[i] = Integer.parseInt(nums_str[i]);
        System.out.println(new Solution2().singleNumber(nums));
    }
}