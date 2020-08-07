package main.java.com.jiang.leetcode100.meeting_rooms_II;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution2 {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            if(!queue.isEmpty() && queue.peek() <= intervals[i][0]) queue.poll();
            queue.add(intervals[i][1]);
        }
        return queue.size();
    }
}

public class MeetingRoomsII2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[][] intervals = new int[nums_str.length / 2][2];
        for(int i = 0; i < nums_str.length; i++) {
            intervals[i / 2][i % 2] = Integer.parseInt(nums_str[i]);
        }

        System.out.println(new Solution2().minMeetingRooms(intervals));
    }
}