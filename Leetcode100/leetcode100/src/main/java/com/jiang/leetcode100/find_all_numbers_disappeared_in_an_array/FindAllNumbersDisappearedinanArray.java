package main.java.com.jiang.leetcode100.find_all_numbers_disappeared_in_an_array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                int t = nums[i];
                if(nums[t - 1] != t) {
                    nums[i] = nums[t - 1];
                    nums[t - 1] = t;
                    i--;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) result.add(i + 1);
        }
        return result;
    }
}

public class FindAllNumbersDisappearedinanArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums.length; i++) nums[i] = Integer.parseInt(nums_str[i]);

        List<Integer> result = new Solution().findDisappearedNumbers(nums);
        for(Integer num : result) System.out.print(num + " ");
    }
}