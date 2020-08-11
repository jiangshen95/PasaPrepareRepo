package main.java.com.jiang.leetcode100.best_time_to_buy_and_sell_stock_with_cooldown;

import java.util.Scanner;

class Solution2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0) return 0;

        int[][] dp = new int[n][3];  // dp[i][0]:手上持有股票 dp[i][1]:不持有，冷冻期 dp[i][2] 不持有，非冷冻期

        for(int i = 0; i < n; i++) {
            if(i == 0) {
                dp[i][0] = -prices[i];
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
                dp[i][1] = dp[i - 1][0] + prices[i];
                dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            }
        }
        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }
}

public class BestTimetoBuyandSellStockwithCooldown2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] prices = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) prices[i] = Integer.parseInt(nums_str[i]);

        System.out.println(new Solution2().maxProfit(prices));
    }
}