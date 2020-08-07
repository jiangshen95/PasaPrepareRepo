package main.java.com.jiang.leetcode100.perfect_squares;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution3 {
    public int numSquares(int n) {
        for(int i = 1; i <= n; i++) {
            if(can_devided_by(n, i)) return i;
        }
        return 0;
    }

    private boolean can_devided_by(int n, int count) {
        int sq = (int) Math.sqrt(n);
        if(count == 1) return sq * sq == n;
        for(int i = 1; i <= sq; i++) {
            if(can_devided_by(n - i * i, count - 1)) return true;
        }
        return false;
    }
}

public class PerfectSquares3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(new Solution3().numSquares(n));
    }
}