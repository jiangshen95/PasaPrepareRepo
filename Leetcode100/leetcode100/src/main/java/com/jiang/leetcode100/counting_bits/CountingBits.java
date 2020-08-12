package main.java.com.jiang.leetcode100.counting_bits;

import java.util.Scanner;

class Solution {
    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        for(int i = 0; i <= num; i++) {
            int count = 0, n = i;
            while(n > 0) {
                if((n & 1) > 0) count++;
                n >>= 1;
            }
            bits[i] = count;
        }
        return bits;
    }
}

public class CountingBits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();
        int[] result = new Solution().countBits(num);
        for(int n : result) {
            System.out.print(n + " ");
        }
    }
}