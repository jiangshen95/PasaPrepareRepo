package main.java.com.jiang.leetcode100.permutations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Solution3 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) one.add(nums[i]);
        helper(nums.length, 0, one, result);
        return result;
    }

    public void helper(int n, int first, List<Integer> one, List<List<Integer>> result) {
        if(first == n) {
            List<Integer> temp = new ArrayList<>(one);
            result.add(temp);
            return;
        }
        for(int i = first; i < n; i++) {
            Collections.swap(one, first, i);
            helper(n, first + 1, one, result);
            Collections.swap(one, first, i);
        }
    }
}

public class Permutations3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }
        List<List<Integer>> result = new Solution3().permute(nums);
        for(List<Integer> line : result) {
            for(Integer num : line) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}