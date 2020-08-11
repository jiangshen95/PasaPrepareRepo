package main.java.com.jiang.leetcode100.best_time_to_buy_and_sell_stock_with_cooldown;

import java.util.Scanner;

class Solution4 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n <= 1) return 0;

        int buy = 0, sell = 0, pre_buy = 0, pre_sell = 0;

        for(int i = 0; i < n; i++) {
            if(i == 0) buy = -prices[i];
            else {
                pre_buy = buy;
                buy = Math.max(pre_sell - prices[i], pre_buy);
                pre_sell = sell;
                sell = Math.max(pre_buy + prices[i], pre_sell);
            }
        }
        return sell;
    }
}

public class BestTimetoBuyandSellStockwithCooldown4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] prices = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) prices[i] = Integer.parseInt(nums_str[i]);

        System.out.println(new Solution4().maxProfit(prices));
    }
}