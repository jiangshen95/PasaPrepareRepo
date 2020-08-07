package main.java.com.jiang.leetcode100.meeting_rooms_II;

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for(int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int result = 0;
        int j = 0;
        for(int i = 0; i < n; i++) {
            if(starts[i] < ends[j]) result++;
            else j++;
        }
        return result;
    }
}

public class MeetingRoomsII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[][] intervals = new int[nums_str.length / 2][2];
        for(int i = 0; i < nums_str.length; i++) {
            intervals[i / 2][i % 2] = Integer.parseInt(nums_str[i]);
        }

        System.out.println(new Solution().minMeetingRooms(intervals));
    }
}