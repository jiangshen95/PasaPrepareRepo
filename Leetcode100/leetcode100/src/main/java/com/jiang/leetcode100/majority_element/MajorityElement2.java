package main.java.com.jiang.leetcode100.majority_element;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution2 {
    public int majorityElement(int[] nums) {
        int count = 0, candidate = 0;
        for(int num : nums) {
            if(count == 0) candidate = num;
            if(num == candidate) count++;
            else count--;
        }
        return candidate;
    }
}

public class MajorityElement2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) nums[i] = Integer.parseInt(nums_str[i]);

        System.out.println(new Solution2().majorityElement(nums));
    }
}