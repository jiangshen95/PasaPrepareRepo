package main.java.com.jiang.leetcode100.task_scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution2 {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for(char ch : tasks) map[ch - 'A']++;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for(int i = 0; i < 26; i++) {
            if(map[i] != 0) priorityQueue.add(map[i]);
        }
        int time = 0;
        while(!priorityQueue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int i = 0;
            while(i <= n) {
                if(!priorityQueue.isEmpty()) {
                    if(priorityQueue.peek() > 1) temp.add(priorityQueue.poll() - 1);
                    else priorityQueue.poll();
                }
                time++;
                if(priorityQueue.isEmpty() && temp.isEmpty()) break;
                i++;
            }
            priorityQueue.addAll(temp);
        }
        
        return time;
    }
}

public class TaskScheduler2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int n = scanner.nextInt();
        scanner.close();
        char[] tasks = str.toCharArray();
        System.out.println(new Solution2().leastInterval(tasks, n));
    }
}