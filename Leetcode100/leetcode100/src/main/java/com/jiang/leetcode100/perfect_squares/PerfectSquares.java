package main.java.com.jiang.leetcode100.perfect_squares;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    private Map<Integer, Integer> memo = new HashMap<>();
    public int numSquares(int n) {
        if(n == 0) return 0;
        if(memo.containsKey(n)) return memo.get(n);
        int result = Integer.MAX_VALUE;
        for(int i = 1; i * i <= n; i++) {
            result = Math.min(result, numSquares(n - i * i));
        }
        memo.put(n, result + 1);
        return result + 1;
    }
}

public class PerfectSquares {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(new Solution().numSquares(n));
    }
}