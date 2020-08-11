package main.java.com.jiang.leetcode100.coin_change;

import java.util.Arrays;
import java.util.Scanner;

class Solution2 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int coin : coins) {
            for(int j = coin; j <= amount; j++) {
                if(dp[j - coin] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}

public class CoinChange2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int amount = scanner.nextInt();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] coins = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) coins[i] = Integer.parseInt(nums_str[i]);

        System.out.println(new Solution2().coinChange(coins, amount));
    }
}