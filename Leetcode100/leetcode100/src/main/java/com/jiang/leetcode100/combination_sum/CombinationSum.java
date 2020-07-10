package main.java.com.jiang.leetcode100.combination_sum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        dfs(candidates, target, 0, one, result);
        return result;
    }

    public void dfs(int[] candidates, int target, int index, 
        List<Integer> one, List<List<Integer>> result) {
        if(target == 0) {
            List<Integer> new_res = new ArrayList<>(one);
            result.add(new_res);
            return;
        }
        if(target < 0) return;
        for(int i = index; i < candidates.length; i++) {
            one.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, one, result);
            one.remove(Integer.valueOf(candidates[i]));
        }
    }
}

public class CombinationSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int target = scanner.nextInt();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] candidates = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            candidates[i] = Integer.parseInt(nums_str[i]);
        }
        
        List<List<Integer>> result = new Solution().combinationSum(candidates, target);
        for(List<Integer> line : result) {
            for(Integer num : line) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}