package main.java.com.jiang.leetcode100.house_robber_III;

import java.util.ArrayDeque;
import java.util.HashMap;
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

class Solution3 {
    public int rob(TreeNode root) {
        int[] root_status = dfs(root);
        return Math.max(root_status[0], root_status[1]);
    }

    private int[] dfs(TreeNode root) {
        if(root == null) return new int[]{0, 0};
        int[] left_stauts = dfs(root.left);
        int[] right_status = dfs(root.right);
        int use = root.val + left_stauts[1] + right_status[1];
        int unuse = Math.max(left_stauts[0], left_stauts[1]) + 
            Math.max(right_status[0], right_status[1]);
        return new int[]{use, unuse};
    }
}

public class HouseRobberIII3 {
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

        System.out.println(new Solution3().rob(root));
    }
}