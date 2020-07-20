package main.java.com.jiang.leetcode100.edit_distance;

import java.util.Scanner;

class Solution2 {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[] dp = new int[l2 + 1];
        for(int i = 0; i <= l2; i++) dp[i] = i;

        for(int i = 1; i <= l1; i++) {
            int pre = dp[0];
            dp[0] = i;
            for(int j = 1; j <= l2; j++) {
                int temp = dp[j];
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = Math.min(pre, 
                        Math.min(dp[j] + 1, dp[j - 1] + 1));
                } else {
                    dp[j] = Math.min(pre + 1, 
                        Math.min(dp[j] + 1, dp[j - 1] + 1));
                }
                pre = temp;
            }
        }
        return dp[l2];
    }
}

public class EditDistance2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word1 = scanner.nextLine();
        String word2 = scanner.nextLine();
        scanner.close();
        System.out.println(new Solution2().minDistance(word1, word2));
    }
}