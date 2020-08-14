package main.java.com.jiang.leetcode100.task_scheduler;

import java.util.Scanner;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for(char ch : tasks) map[ch - 'A']++;
        int time = 0, pre = 0;
        while(true) {
            int count = 0;
            for(int i = 0; i < 26; i++) {
                if(map[i] > 0) {
                    count++;
                    map[i]--;
                }
                if(count == n + 1) break;
            }
            if(count == 0) {
                time -= n + 1 - pre;
                break;
            }
            pre = count;
            time += n + 1;
            System.out.println("time: " + time);
        }
        return time;
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int n = scanner.nextInt();
        scanner.close();
        char[] tasks = str.toCharArray();
        System.out.println(new Solution().leastInterval(tasks, n));
    }
}