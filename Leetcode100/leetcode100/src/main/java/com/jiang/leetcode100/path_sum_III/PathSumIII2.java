package main.java.com.jiang.leetcode100.path_sum_III;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution2 {
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        List<Integer> sumList = new ArrayList<>();
        return helper(root, sum, sumList);
    }

    private int helper(TreeNode root, int sum, List<Integer> sumList) {
        if(root == null) return 0;
        List<Integer> temp = new ArrayList<>();
        for(Integer num : sumList) {
            temp.add(num + root.val);
        }
        temp.add(root.val);

        int count = 0;
        for(Integer num : temp) {
            if(num == sum) count++;
        }
        return count + helper(root.left, sum, temp) + helper(root.right, sum, temp);
    }
}

public class PathSumIII2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int sum = scanner.nextInt();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new  int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }

        TreeNode root = new TreeNode(nums[0], null, null);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        for(int i = 1; i < nums.length; i += 2) {
            TreeNode cur = queue.poll();
            if(nums[i] != -1) {
                cur.left = new TreeNode(nums[i], null, null);
                queue.add(cur.left);
            }
            if(nums[i + 1] != -1) {
                cur.right = new TreeNode(nums[i + 1], null, null);
                queue.add(cur.right);
            }
        }

        System.out.println(new Solution2().pathSum(root, sum));
    }
}