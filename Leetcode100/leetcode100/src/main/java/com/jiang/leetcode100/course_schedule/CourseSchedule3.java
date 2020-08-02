package main.java.com.jiang.leetcode100.course_schedule;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class Solution3 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) adjacency.add(new ArrayList<>());
        for(int i = 0; i < prerequisites.length; i++) {
            adjacency.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegrees[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegrees[i] == 0) queue.add(i);
        }

        int count = 0;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            count++;
            for(Integer v : adjacency.get(cur)) {
                indegrees[v]--;
                if(indegrees[v] == 0) queue.add(v);
            }
        }

        return count == numCourses;
    }
}

public class CourseSchedule3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCourses = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] prerequisites = new int[n][2];
        for(int i = 0; i < n; i++) {
            prerequisites[i][0] = scanner.nextInt();
            prerequisites[i][1] = scanner.nextInt();
        }
        scanner.close();

        if(new Solution3().canFinish(numCourses, prerequisites)) {
            System.out.println("true");
        } else System.out.println("false");
    }
}