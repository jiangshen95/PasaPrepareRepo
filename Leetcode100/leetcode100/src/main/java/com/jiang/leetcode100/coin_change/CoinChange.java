package main.java.com.jiang.leetcode100.coin_change;

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int i = 0; i <= amount; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(i - coins[j] >= 0 && dp[i - coins[j]] != -1) {
                    if(dp[i] == -1) dp[i] = dp[i - coins[j]] + 1;
                    else dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount];
    }
}

public class CoinChange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int amount = scanner.nextInt();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] coins = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) coins[i] = Integer.parseInt(nums_str[i]);

        System.out.println(new Solution().coinChange(coins, amount));
    }
}