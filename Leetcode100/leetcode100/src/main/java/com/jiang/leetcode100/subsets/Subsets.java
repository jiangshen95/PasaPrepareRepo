package main.java.com.jiang.leetcode100.subsets;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        helper(result, one, nums, 0);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> one, int[] nums, int index) {
        result.add(new ArrayList<>(one));

        for(int i = index; i < nums.length; i++) {
            one.add(nums[i]);
            helper(result, one, nums, i + 1);
            one.remove(Integer.valueOf(nums[i]));
        }
    }
}

public class Subsets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }

        List<List<Integer>> result = new Solution().subsets(nums);
        for(List<Integer> line : result) {
            for(Integer num : line) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}