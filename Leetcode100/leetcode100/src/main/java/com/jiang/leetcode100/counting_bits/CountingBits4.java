package main.java.com.jiang.leetcode100.counting_bits;

import java.util.Scanner;

class Solution4 {
    public int[] countBits(int num) {
        int[] bits = new int[num + 1];

        for(int i = 1; i <= num; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }

        return bits;
    }
}

public class CountingBits4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();
        int[] result = new Solution4().countBits(num);
        for(int n : result) {
            System.out.print(n + " ");
        }
    }
}