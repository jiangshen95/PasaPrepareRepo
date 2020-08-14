package main.java.com.jiang.leetcode100.task_scheduler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution3 {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for(char ch : tasks) map[ch - 'A']++;
        Arrays.sort(map);

        int max_val = map[25] - 1, idle_slots = max_val * n;
        for(int i = 24; i >= 0 && map[i] > 0; i--) {
            idle_slots -= Math.min(map[i], max_val);
        }

        return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
    }
}

public class TaskScheduler3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int n = scanner.nextInt();
        scanner.close();
        char[] tasks = str.toCharArray();
        System.out.println(new Solution3().leastInterval(tasks, n));
    }
}