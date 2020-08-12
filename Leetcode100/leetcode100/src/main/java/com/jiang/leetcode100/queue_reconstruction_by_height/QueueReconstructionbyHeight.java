package main.java.com.jiang.leetcode100.queue_reconstruction_by_height;

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (v1, v2) -> v1[0] == v2[0] ? v2[1] - v1[1] : v1[0] - v2[0]);
        int[][] result = new int[people.length][2];
        boolean[] visited = new boolean[people.length];
        for(int i = 0; i < people.length; i++) {
            int before = 0;

            for(int j = 0; j < people.length; j++) {
                if(!visited[j] && before == people[i][1]) {
                    result[j] = people[i];
                    visited[j] = true;
                    break;
                }
                if(!visited[j]) before++;
            }
        }
        return result;
    }
}

public class QueueReconstructionbyHeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[][] people = new int[nums_str.length / 2][2];
        for(int i = 0; i < nums_str.length; i += 2) {
            people[i / 2][0] = Integer.parseInt(nums_str[i]);
            people[i / 2][1] = Integer.parseInt(nums_str[i + 1]);
        }

        int[][] result = new Solution().reconstructQueue(people);
        for(int i = 0; i < result.length; i++) {
            System.out.print("[ " + result[i][0] + ", " + result[i][1] + " ] ");
        }
    }
}