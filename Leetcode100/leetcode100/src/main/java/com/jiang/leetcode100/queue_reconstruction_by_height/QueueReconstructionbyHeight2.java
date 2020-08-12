package main.java.com.jiang.leetcode100.queue_reconstruction_by_height;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Solution2 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (v1, v2) -> v1[0] == v2[0] ? v1[1] - v2[1] : v2[0] - v1[0]);
        List<int[]> output = new LinkedList<>();
        for(int i = 0; i < people.length; i++) {
            output.add(people[i][1], people[i]);
        }
        return output.toArray(new int[people.length][2]);
    }
}

public class QueueReconstructionbyHeight2 {
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

        int[][] result = new Solution2().reconstructQueue(people);
        for(int i = 0; i < result.length; i++) {
            System.out.print("[ " + result[i][0] + ", " + result[i][1] + " ] ");
        }
    }
}