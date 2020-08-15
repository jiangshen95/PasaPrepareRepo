package main.java.com.jiang.leetcode100.daily_temperatures;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

class Solution2 {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] result = new int[n];

        int[] next = new int[101];
        Arrays.fill(next, Integer.MAX_VALUE);
        for(int i = n - 1; i >= 0; i--) {
            int warmerIndex = Integer.MAX_VALUE;
            for(int j = T[i] + 1; j <= 100; j++) {
                warmerIndex = Math.min(warmerIndex, next[j]);
            }
            if(warmerIndex != Integer.MAX_VALUE) result[i] = warmerIndex - i;
            next[T[i]] = i;
        }
        return result;
    }
}

public class DailyTemperatures2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] T = new int[nums_str.length];
        for(int i = 0; i < T.length; i++) T[i] = Integer.parseInt(nums_str[i]);

        int[] result = new Solution2().dailyTemperatures(T);
        for(int t : result) System.out.print(t + " ");
    }
}