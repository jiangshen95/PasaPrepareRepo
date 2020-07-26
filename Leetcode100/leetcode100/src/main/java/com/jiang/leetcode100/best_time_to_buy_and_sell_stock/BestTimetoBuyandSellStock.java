package main.java.com.jiang.leetcode100.best_time_to_buy_and_sell_stock;

import java.util.Scanner;

class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int result = 0;
        int min_price = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
            result = Math.max(result, prices[i] - min_price);
            min_price = Math.min(min_price, prices[i]);
        }
        return result;
    }
}

public class BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] prices = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            prices[i] = Integer.parseInt(nums_str[i]);
        }
        System.out.println(new Solution().maxProfit(prices));
    }
}