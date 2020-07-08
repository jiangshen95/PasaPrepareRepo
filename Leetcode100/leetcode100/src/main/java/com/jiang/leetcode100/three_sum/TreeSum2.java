package main.java.com.jiang.leetcode100.three_sum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        qsort(nums, 0, nums.length - 1);

        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int target = 0 - nums[i];
            int begin = i + 1, end = nums.length - 1;
            while(begin < end) {
                if(nums[begin] + nums[end] < target) {
                    begin++;
                } else if(nums[begin] + nums[end] > target) {
                    end--;
                } else {
                    if(begin > i + 1 && nums[begin] == nums[begin - 1]) {
                        begin++;
                        continue;
                    }
                    List<Integer> one = new ArrayList<>();
                    one.add(nums[i]);
                    one.add(nums[begin]);
                    one.add(nums[end]);
                    result.add(one);
                    begin++;
                    end--;
                }
            }
        }

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
}

public class TreeSum2 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();

        String[] nums_str = str.split(" ");
        int[] nums  =new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }

        List<List<Integer>> result = new Solution2().threeSum(nums);
        for(int i = 0; i < result.size(); i++) {
            for(int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println("");
        }
    }

}