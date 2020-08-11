package main.java.com.jiang.leetcode100.best_time_to_buy_and_sell_stock_with_cooldown;

import java.util.Scanner;

class Solution3 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n <= 1) return 0;

        int dp0 = -prices[0], dp1 = 0, dp2 = 0;

        for(int i = 1; i < n; i++) {
            int t0 = Math.max(dp0, dp2 - prices[i]);
            int t1 = dp0 + prices[i];
            int t2 = Math.max(dp1, dp2);
            dp0 = t0;
            dp1 = t1;
            dp2 = t2;
        }
        return Math.max(dp1, dp2);
    }
}

public class BestTimetoBuyandSellStockwithCooldown3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] prices = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) prices[i] = Integer.parseInt(nums_str[i]);

        System.out.println(new Solution3().maxProfit(prices));
    }
}