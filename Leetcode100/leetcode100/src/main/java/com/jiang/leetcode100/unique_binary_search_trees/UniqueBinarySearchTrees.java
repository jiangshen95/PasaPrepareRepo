package main.java.com.jiang.leetcode100.unique_binary_search_trees;

import java.util.Scanner;

class Solution {
    public int numTrees(int n) {
        if(n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i] += dp[i - j] * dp[j - 1];
            }
        }
        return dp[n];
    }
}

public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(new Solution().numTrees(n));
    }
}