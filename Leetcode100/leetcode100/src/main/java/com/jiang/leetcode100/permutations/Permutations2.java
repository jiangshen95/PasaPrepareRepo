package main.java.com.jiang.leetcode100.permutations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Solution2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length <= 0) return result;
        result.add(new ArrayList<>());

        int n = nums.length;
        for(int i = 0; i < n; i++) {
            List<List<Integer>> temp = new ArrayList<>();
            for(List<Integer> line : result) {
                for(int j = 0; j < n; j++) {
                    if(!line.contains(nums[j])) {
                        List<Integer> new_one = new ArrayList<>(line);
                        new_one.add(nums[j]);
                        temp.add(new ArrayList<>(new_one));
                    }
                }
            }
            result = temp;
        }
        return result;
    }
}

public class Permutations2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }
        List<List<Integer>> result = new Solution2().permute(nums);
        for(List<Integer> line : result) {
            for(Integer num : line) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}