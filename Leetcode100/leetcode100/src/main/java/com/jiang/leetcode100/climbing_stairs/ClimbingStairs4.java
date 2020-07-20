package main.java.com.jiang.leetcode100.climbing_stairs;

import java.util.Scanner;

class Solution4 {
    public int climbStairs(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int)(fibn / sqrt5);
    }
}

public class ClimbingStairs4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        scanner.close();
        System.out.println(new Solution4().climbStairs(n));
    }
}