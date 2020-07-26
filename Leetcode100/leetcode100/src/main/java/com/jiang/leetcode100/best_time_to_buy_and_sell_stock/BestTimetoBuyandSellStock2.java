package main.java.com.jiang.leetcode100.best_time_to_buy_and_sell_stock;

import java.util.Scanner;

class Solution2 {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int dp0 = 0, dp1 = -prices[0];
        for(int i = 1; i < prices.length; i++) {
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, -prices[i]);
        }
        return Math.max(dp0, dp1);
    }
}

public class BestTimetoBuyandSellStock2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] prices = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            prices[i] = Integer.parseInt(nums_str[i]);
        }
        System.out.println(new Solution2().maxProfit(prices));
    }
}