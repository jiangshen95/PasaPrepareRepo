package main.java.com.jiang.leetcode100.path_sum_III;

import java.util.ArrayDeque;
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

class Solution {
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int helper(TreeNode root, int sum) {
        if(root == null) return 0;
        int result = sum == root.val ? 1 : 0;
        return result + helper(root.left, sum - root.val) + helper(root.right, sum - root.val);
    }
}

public class PathSumIII {
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

        System.out.println(new Solution().pathSum(root, sum));
    }
}