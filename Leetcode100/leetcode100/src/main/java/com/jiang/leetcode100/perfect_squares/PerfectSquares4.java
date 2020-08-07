package main.java.com.jiang.leetcode100.perfect_squares;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class Solution4 {
    public int numSquares(int n) {
        int result = 0;
        List<Integer> queue = new ArrayList<>();
        queue.add(n);
        while(!queue.isEmpty()) {
            result++;
            List<Integer> temp = new ArrayList<>();
            for(Integer num : queue) {
                for(int i = 1; i * i <= num; i++) {
                    if(num == i * i) return result;
                    else {
                        temp.add(num - i * i);
                    }
                }
            }
            queue = temp;
        }
        return result;
    }
}

public class PerfectSquares4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(new Solution4().numSquares(n));
    }
}