package main.java.com.jiang.leetcode100.flatten_binary_tree_to_linked_list;

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

class Solution5 {
    TreeNode pre = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.left);
        flatten(root.right);

        TreeNode cur = root.left;
        if(cur == null) return;
        while(cur.right != null) cur = cur.right;
        cur.right = root.right;
        root.right = root.left;
        root.left = null;
    }
}

public class FlattenBinaryTreetoLinkedList5 {
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

        new Solution5().flatten(root);
        printTree(root);

    }

    public static void printTree(TreeNode root) {
        if(root == null) return;
        System.out.print(root.val + " ");
        printTree(root.right);
    }
}