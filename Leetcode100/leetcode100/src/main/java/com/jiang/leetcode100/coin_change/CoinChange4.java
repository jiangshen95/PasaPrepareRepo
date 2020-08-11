package main.java.com.jiang.leetcode100.coin_change;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution4 {
    private int result = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        Arrays.sort(coins);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[amount + 1];

        visited[amount] = true;
        queue.offer(amount);

        int step = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int head = queue.poll();
                for(int coin : coins) {
                    int next = head - coin;
                    if(next == 0) {
                        return step;
                    }
                    if(next < 0) {
                        break;
                    }
                    if(!visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}

public class CoinChange4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int amount = scanner.nextInt();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] coins = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) coins[i] = Integer.parseInt(nums_str[i]);

        System.out.println(new Solution4().coinChange(coins, amount));
    }
}