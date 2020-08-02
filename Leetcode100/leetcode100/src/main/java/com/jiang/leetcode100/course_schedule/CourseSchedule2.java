package main.java.com.jiang.leetcode100.course_schedule;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[][] edge = new boolean[numCourses][numCourses];
        for(int i = 0; i < prerequisites.length; i++) {
            edge[prerequisites[i][1]][prerequisites[i][0]] = true;
        }

        boolean[] visited = new boolean[numCourses];
        return topology(numCourses, prerequisites, visited, 0);
    }

    private boolean topology(int numCourses, int[][] prerequisites, boolean[] visited, int count) {
        if(count == numCourses) return true;
        int[] indegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++) {
            if(prerequisites[i][0] != -1) indegree[prerequisites[i][0]]++;
        }
        boolean flag = false;
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0 && !visited[i]) {
                visited[i] = true;
                for(int j = 0; j < prerequisites.length; j++) {
                    if(prerequisites[j][1] == i) prerequisites[j][0] = -1;
                }
                count++;
                flag = true;
            }
        }
        if(!flag) return false;
        return topology(numCourses, prerequisites, visited, count);
    }
}

public class CourseSchedule2 {
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

        if(new Solution2().canFinish(numCourses, prerequisites)) {
            System.out.println("true");
        } else System.out.println("false");
    }
}