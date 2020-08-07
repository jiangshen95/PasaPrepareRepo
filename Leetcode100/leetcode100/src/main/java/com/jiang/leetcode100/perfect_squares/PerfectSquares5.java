package main.java.com.jiang.leetcode100.perfect_squares;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class Solution5 {
    public int numSquares(int n) {
        if(isSquare(n)) return 1;
        while((n & 3) == 0) n >>= 2;
        if((n & 7) == 7) return 4;

        for(int i = 1; i * i <= n; i++) {
            if(isSquare(n - i * i)) return 2;
        }
        
        return 3;
    }
    private boolean isSquare(int n) {
        int sq = (int) Math.sqrt(n);
        if(sq * sq == n) return true;
        return false;
    }
}

public class PerfectSquares5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(new Solution5().numSquares(n));
    }
}