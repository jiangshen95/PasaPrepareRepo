package main.java.com.jiang.leetcode100.permutations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        helper(nums, one, result);
        return result;
    }

    public void helper(int[] nums, List<Integer> one, List<List<Integer>> result) {
        if(one.size() == nums.length) {
            List<Integer> temp = new ArrayList<>(one);
            result.add(temp);
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!one.contains(nums[i])) {
                one.add(nums[i]);
                helper(nums, one, result);
                one.remove(Integer.valueOf(nums[i]));
            }
        }
    }
}

public class Permutations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }
        List<List<Integer>> result = new Solution().permute(nums);
        for(List<Integer> line : result) {
            for(Integer num : line) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}