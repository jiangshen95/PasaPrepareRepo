package main.java.com.jiang.leetcode100.merge_intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Solution2 {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n == 0) return intervals;
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        // Arrays.sort(intervals, Comparator.comparing(o -> o[0]));
        int index = 0;
        for(int i = 0; i < n; i++) {
            if(intervals[i][0] <= intervals[index][1]) {
                intervals[index][1] = Math.max(intervals[index][1], intervals[i][1]);
            } else {
                index++;
                intervals[index] = intervals[i];
            }
        }

        return Arrays.copyOf(intervals, index + 1);
    }
}

public class MergeIntervals2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[][] intervals = new int[nums_str.length / 2][2];
        for(int i = 0; i < nums_str.length; i+=2) {
            intervals[i / 2][0] = Integer.parseInt(nums_str[i]);
            intervals[i / 2][1] = Integer.parseInt(nums_str[i + 1]);
        }

        int[][] result = new Solution2().merge(intervals);
        for(int i = 0; i < result.length; i++) {
            System.out.printf("%d, %d\n", result[i][0], result[i][1]);
        }
    }
}