package main.java.com.jiang.leetcode100.top_k_frequent_elements;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((v1, v2) -> map.get(v1) - map.get(v2));

        for(Integer key : map.keySet()) {
            heap.add(key);
            if(heap.size() > k) heap.poll();
        }

        int[] result = new int[k];
        for(int i = k - 1; i >= 0; i--) result[i] = heap.poll();
        return result;
    }
}

public class TopKFrequentElements2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int k = scanner.nextInt();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums.length; i++) nums[i] = Integer.parseInt(nums_str[i]);

        int[] result = new Solution2().topKFrequent(nums, k);
        for(int i = 0; i < result.length; i++) System.out.print(result[i] + " ");
    }
}