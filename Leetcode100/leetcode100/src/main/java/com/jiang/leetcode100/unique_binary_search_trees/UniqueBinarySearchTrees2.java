package main.java.com.jiang.leetcode100.unique_binary_search_trees;

import java.util.Scanner;

/**
 * 数学方法，卡塔兰数
 */
class Solution2 {
    public int numTrees(int n) {
        long c = 1;
        for(int i = 0; i < n; i++) {
            c = c * 2 * (2 * i + 1) / (i + 2);
        }
        return (int)c;
    }
}

public class UniqueBinarySearchTrees2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(new Solution2().numTrees(n));
    }
}