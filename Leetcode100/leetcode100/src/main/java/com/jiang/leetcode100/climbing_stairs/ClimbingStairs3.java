package main.java.com.jiang.leetcode100.climbing_stairs;

import java.util.Scanner;

class Solution3 {
    public int climbStairs(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }

    public int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while(n > 0) {
            if((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                c[i][j] += a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }
}

public class ClimbingStairs3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        scanner.close();
        System.out.println(new Solution3().climbStairs(n));
    }
}