package main.java.com.jiang.leetcode100.counting_bits;

import java.util.Scanner;

class Solution3 {
    public int[] countBits(int num) {
        int[] bits = new int[num + 1];

        int i = 0, b = 1;
        while(b <= num) {
            while(i < b && i + b <= num) {
                bits[i + b] = bits[i] + 1;
                i++;
            }
            i = 0;
            b <<= 1;
        }
        return bits;
    }
}

public class CountingBits3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();
        int[] result = new Solution3().countBits(num);
        for(int n : result) {
            System.out.print(n + " ");
        }
    }
}