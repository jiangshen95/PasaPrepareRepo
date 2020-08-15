package main.java.com.jiang.leetcode100.daily_temperatures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && T[i] > T[stack.getFirst()]) {
                int t = stack.pop();
                result[t] = i - t;
            }
            stack.push(i);
        }
        return result;
    }
}

public class DailyTemperatures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] T = new int[nums_str.length];
        for(int i = 0; i < T.length; i++) T[i] = Integer.parseInt(nums_str[i]);

        int[] result = new Solution().dailyTemperatures(T);
        for(int t : result) System.out.print(t + " ");
    }
}