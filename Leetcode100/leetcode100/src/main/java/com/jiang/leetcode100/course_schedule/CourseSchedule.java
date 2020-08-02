package main.java.com.jiang.leetcode100.course_schedule;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[][] edge = new boolean[numCourses][numCourses];
        for(int i = 0; i < prerequisites.length; i++) {
            edge[prerequisites[i][1]][prerequisites[i][0]] = true;
        }

        boolean[] visited = new boolean[numCourses];
        Map<Integer, Boolean> memo = new HashMap<>();
        for(int i = 0; i < numCourses; i++) {
            if(!dfs(numCourses, edge, visited, i, memo)) return false;
            Arrays.fill(visited, false);
        }
        return true;
    }

    private boolean dfs(int numCourses, boolean[][] edge, 
        boolean[] visited, int v, Map<Integer, Boolean> memo) {
        if(memo.containsKey(v)) return memo.get(v);
        visited[v] = true;
        for(int i = 0; i < numCourses; i++) {
            if(edge[v][i]) {
                if(visited[i]) {
                    memo.put(v, false);
                    return false;
                }
                if(!dfs(numCourses, edge, visited, i, memo)) {
                    memo.put(v, false);
                    return false;
                }
                visited[i] = false;
            }
        }
        memo.put(v, true);
        return true;
    }
}

public class CourseSchedule {
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

        if(new Solution().canFinish(numCourses, prerequisites)) {
            System.out.println("true");
        } else System.out.println("false");
    }
}