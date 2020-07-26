package main.java.com.jiang.leetcode100.longest_consecutive_sequence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Solution4 {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        UnionFind uf = new UnionFind(nums);
        for(int v : nums) {
            uf.union(v, v + 1);
        }
        int max = 1;
        for(int v : nums) max = Math.max(max, uf.find(v) - v + 1);
        return max;
    }
}

class UnionFind {
    private int count;
    private Map<Integer, Integer> parent;

    UnionFind(int[] arr) {
        count = arr.length;
        parent = new HashMap<>();
        for(int v : arr) parent.put(v, v);
    }

    void union(int p, int q) {
        Integer rootP = find(p), rootQ = find(q);
        if(rootP == rootQ) return;
        if(rootP == null || rootQ == null) return;

        parent.put(rootP, rootQ);
        count--;
    }

    Integer find(int p) {
        if(!parent.containsKey(p)) return null;
        int root = p;
        while(root != parent.get(root)) root = parent.get(root);

        while(p != parent.get(p)) {
            int cur = p;
            p = parent.get(p);
            parent.put(cur, root);
        }
        return root;
    }

}

public class LongestConsecutiveSequence4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }
        System.out.println(new Solution4().longestConsecutive(nums));
    }
}