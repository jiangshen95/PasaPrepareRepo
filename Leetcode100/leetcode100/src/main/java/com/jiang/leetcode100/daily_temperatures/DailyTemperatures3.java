package main.java.com.jiang.leetcode100.daily_temperatures;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

class Solution3 {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] result = new int[n];

        for(int i = n - 1; i >= 0; i--) {
            for(int j = i + 1; j < n; j += result[j]) {
                if(T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                } else if(result[j] == 0) break;
            }
        }
        return result;
    }
}

public class DailyTemperatures3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] T = new int[nums_str.length];
        for(int i = 0; i < T.length; i++) T[i] = Integer.parseInt(nums_str[i]);

        int[] result = new Solution3().dailyTemperatures(T);
        for(int t : result) System.out.print(t + " ");
    }
}