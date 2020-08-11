package main.java.com.jiang.leetcode100.best_time_to_buy_and_sell_stock_with_cooldown;

import java.util.Scanner;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0) return 0;

        int[] buy = new int[n];
        int[] sell = new int[n];

        for(int i = 0; i < n; i++) {
            if(i == 0) buy[i] = -prices[i];
            else {
                buy[i] = Math.max((i > 1 ? sell[i - 2] : 0) - prices[i], buy[i - 1]);
                sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);
            }
        }
        return sell[n - 1];
    }
}

public class BestTimetoBuyandSellStockwithCooldown {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] prices = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) prices[i] = Integer.parseInt(nums_str[i]);

        System.out.println(new Solution().maxProfit(prices));
    }
}