package main.java.com.jiang.leetcode100.combination_sum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Solution2 {

    class Node {
        int pos;
        int target;
        List<Integer> cur_nums;
        public Node(int pos, int target, List<Integer> cur_nums) {
            this.pos = pos;
            this.target = target;
            this.cur_nums = cur_nums;
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> one = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, target, one));

        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            if(cur.target == 0) {
                result.add(cur.cur_nums);
                continue;
            }
            // System.out.println("target: " + cur.target);
            // System.out.println("pos: " + cur.pos);
            // for(Integer num : cur.cur_nums) System.out.print(num + " ");
            // System.out.println();
            for(int i = cur.pos; i < candidates.length; i++) {
                if(cur.target - candidates[i] >= 0) {
                    List<Integer> new_nums = new ArrayList<>(cur.cur_nums);
                    new_nums.add(candidates[i]);
                    queue.add(new Node(i, cur.target - candidates[i], new_nums));
                }
            }
        }

        return result;
    }
}

public class CombinationSum2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int target = scanner.nextInt();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] candidates = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            candidates[i] = Integer.parseInt(nums_str[i]);
        }
        
        List<List<Integer>> result = new Solution2().combinationSum(candidates, target);
        for(List<Integer> line : result) {
            for(Integer num : line) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}