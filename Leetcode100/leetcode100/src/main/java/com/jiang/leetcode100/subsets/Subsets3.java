package main.java.com.jiang.leetcode100.subsets;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution3 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < (1 << nums.length); i++) {
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < nums.length; j++) {
                if(((i >> j) & 1) == 1) {
                    temp.add(nums[j]);
                }
            }
            result.add(new ArrayList<>(temp));
        }
        return result;
    }
}

public class Subsets3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }

        List<List<Integer>> result = new Solution3().subsets(nums);
        for(List<Integer> line : result) {
            for(Integer num : line) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}