package main.java.com.jiang.leetcode100.maximum_depth_of_binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<Integer> depths = new ArrayDeque<>();
        int result = 0;
        queue.add(root);
        depths.add(1);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int depth = depths.poll();
            result = Math.max(depth, result);
            if(cur.left != null) {
                queue.add(cur.left);
                depths.add(depth + 1);
            }
            if(cur.right != null) {
                queue.add(cur.right);
                depths.add(depth + 1);
            }
        }
        return result;
    }
}

public class MaximumDepthofBinaryTree2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
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

        System.out.println(new Solution2().maxDepth(root));
    }
}