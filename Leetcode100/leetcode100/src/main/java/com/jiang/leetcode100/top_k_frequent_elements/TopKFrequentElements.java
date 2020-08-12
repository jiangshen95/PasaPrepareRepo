package main.java.com.jiang.leetcode100.top_k_frequent_elements;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[][] numCounts = new int[map.size()][2];
        int index = 0;
        for(Integer key : map.keySet()) {
            numCounts[index][0] = key;
            numCounts[index][1] = map.get(key);
            index++;
        }

        Arrays.sort(numCounts, (v1, v2) -> v2[1] - v1[1]);
        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = numCounts[i][0];
        }
        return result;
    }
}

public class TopKFrequentElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int k = scanner.nextInt();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums.length; i++) nums[i] = Integer.parseInt(nums_str[i]);

        int[] result = new Solution().topKFrequent(nums, k);
        for(int i = 0; i < result.length; i++) System.out.print(result[i] + " ");
    }
}