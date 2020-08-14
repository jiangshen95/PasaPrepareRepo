package main.java.com.jiang.leetcode100.task_scheduler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution4 {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for(char ch : tasks) map[ch - 'A']++;
        Arrays.sort(map);

        int max_val = map[25];
        int time = (max_val - 1) * (n + 1) + 1;
        for(int i = 24; i >= 0 && map[i] == max_val; i--) {
            time++;
        }

        return time < tasks.length ? tasks.length : time;
    }
}

public class TaskScheduler4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int n = scanner.nextInt();
        scanner.close();
        char[] tasks = str.toCharArray();
        System.out.println(new Solution4().leastInterval(tasks, n));
    }
}