package main.java.com.jiang.leetcode100.counting_bits;

import java.util.Scanner;

class Solution5 {
    public int[] countBits(int num) {
        int[] bits = new int[num + 1];

        for(int i = 1; i <= num; i++) {
            bits[i] = bits[i & (i - 1)] + 1;
        }

        return bits;
    }
}

public class CountingBits5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();
        int[] result = new Solution5().countBits(num);
        for(int n : result) {
            System.out.print(n + " ");
        }
    }
}