package main.java.com.jiang.leetcode100.course_schedule;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class Solution4 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) adjacency.add(new ArrayList<>());
        for(int i = 0; i < prerequisites.length; i++) {
            adjacency.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] flags = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if(!dfs(adjacency, flags, i)) return false;
        }
        return true;
        
    }

    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int v) {
        if(flags[v] == -1) return true;
        if(flags[v] == 1) return false;
        flags[v] = 1;
        for(Integer node : adjacency.get(v)) {
            if(!dfs(adjacency, flags, node)) return false;
        }
        flags[v] = -1;
        return true;
    }
}

public class CourseSchedule4 {
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

        if(new Solution4().canFinish(numCourses, prerequisites)) {
            System.out.println("true");
        } else System.out.println("false");
    }
}