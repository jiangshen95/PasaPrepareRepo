package main.java.com.jiang.leetcode100.three_sum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 超时了
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> line = new ArrayList<>();
        qsort(nums, 0, nums.length - 1);
        treeSumHelper(nums, 0, 0, 0, line, result);
        return result;
    }

    public void qsort(int[] nums, int begin, int end) {
        if(begin >= end) return;
        int v = nums[begin];
        int i = begin, j = end;
        while(i < j) {
            while(i < j && nums[j] >= v) j--;
            nums[i] = nums[j];
            while(i < j && nums[i] <= v) i++;
            nums[j] = nums[i];
        }
        nums[i] = v;
        qsort(nums, begin, i - 1);
        qsort(nums, i + 1, end);
    }

    public void treeSumHelper(int[] nums, int index, int deepth, int sum, 
        List<Integer> line, List<List<Integer>> result) {
        if(deepth == 3) {
            if(sum == 0) {
                List<Integer> t = new ArrayList<>(line);
                result.add(t);
            }
            return;
        }

        for(int i = index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[i - 1]) continue;
            line.add(nums[i]);
            treeSumHelper(nums, i + 1, deepth + 1, sum + nums[i], line, result);
            line.remove(line.indexOf(nums[i]));
        }

    }
}

public class TreeSum {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();

        String[] nums_str = str.split(" ");
        int[] nums  =new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }

        List<List<Integer>> result = new Solution().threeSum(nums);
        for(int i = 0; i < result.size(); i++) {
            for(int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println("\n");
        }
    }

}