package main.java.com.jiang.leetcode100.subsets;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        
        for(int i = 0; i < nums.length; i++) {
            List<List<Integer>> temp = new ArrayList<>();
            for(List<Integer> one : result) {
                List<Integer> new_one = new ArrayList<>(one);
                new_one.add(nums[i]);
                temp.add(new_one);
            }
            result.addAll(temp);
        }

        return result;
    }
}

public class Subsets2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }

        List<List<Integer>> result = new Solution2().subsets(nums);
        for(List<Integer> line : result) {
            for(Integer num : line) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}