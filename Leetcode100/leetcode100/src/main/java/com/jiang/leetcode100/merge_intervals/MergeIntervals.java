package main.java.com.jiang.leetcode100.merge_intervals;

import java.util.List;
import java.util.Scanner;

class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n == 0) return intervals;
        sort(intervals, 0, n - 1);
        int index = 0;
        for(int i = 0; i < n; i++) {
            if(intervals[i][0] <= intervals[index][1]) {
                intervals[index][1] = Math.max(intervals[index][1], intervals[i][1]);
            } else {
                index++;
                intervals[index] = intervals[i];
            }
        }

        int[][] result = new int[index + 1][2];
        for(int i = 0; i <= index; i++){
            result[i][0] = intervals[i][0];
            result[i][1] = intervals[i][1];
        }
        return result;
    }

    public void sort(int[][] nums, int l, int r) {
        if(l >= r) return;
        int i = l, j = r;
        int[] v = nums[i].clone();
        while(i < j) {
            while(i < j && nums[j][0] >= v[0]) j--;
            nums[i] = nums[j];
            while(i < j && nums[i][0] <= v[0]) i++;
            nums[j] = nums[i];
        }
        nums[i] = v;
        sort(nums, l, i - 1);
        sort(nums, i + 1, r);
    }
}

public class MergeIntervals {
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

        int[][] result = new Solution().merge(intervals);
        for(int i = 0; i < result.length; i++) {
            System.out.printf("%d, %d\n", result[i][0], result[i][1]);
        }
    }
}