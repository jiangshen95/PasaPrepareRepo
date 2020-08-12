package main.java.com.jiang.leetcode100.top_k_frequent_elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution3 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] list = new List[nums.length + 1];
        for(Integer key : map.keySet()) {
            int n = map.get(key);
            if(list[n] == null) list[n] = new ArrayList<>();
            list[n].add(key);
        }

        int[] result = new int[k];
        int index = 0;

        for(int i = nums.length; i > 0; i--) {
            if(list[i] == null) continue;
            for(Integer num : list[i]) result[index++] = num;
            if(index >= k) break;
        }

        return result;
    }
}

public class TopKFrequentElements3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int k = scanner.nextInt();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums.length; i++) nums[i] = Integer.parseInt(nums_str[i]);

        int[] result = new Solution3().topKFrequent(nums, k);
        for(int i = 0; i < result.length; i++) System.out.print(result[i] + " ");
    }
}