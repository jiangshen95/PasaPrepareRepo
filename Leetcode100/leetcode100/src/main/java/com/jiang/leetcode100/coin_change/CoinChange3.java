package main.java.com.jiang.leetcode100.coin_change;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Solution3 {
    private int result = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        Arrays.sort(coins);
        helper(coins, amount, coins.length - 1, 0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private void helper(int[] coins, int amount, int index, int count) {
        if(amount == 0) {
            result = Math.min(result, count);
        }
        if(index == -1) return;

        for(int k = amount / coins[index]; k >= 0 && k + count < result; k--) {
            helper(coins, amount - coins[index] * k, index - 1, count + k);
        }
    }
}

public class CoinChange3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int amount = scanner.nextInt();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] coins = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) coins[i] = Integer.parseInt(nums_str[i]);

        System.out.println(new Solution3().coinChange(coins, amount));
    }
}