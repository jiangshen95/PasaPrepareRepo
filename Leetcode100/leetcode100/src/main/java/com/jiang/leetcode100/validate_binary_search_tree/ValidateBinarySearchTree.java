package main.java.com.jiang.leetcode100.validate_binary_search_tree;

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
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(!isValidBST(root.left)) return false;
        if(!isValidBST(root.right)) return false;
        if(root.left != null) {
            TreeNode left_max = root.left;
            while(left_max.right != null) {
                left_max = left_max.right;
            }
            if(left_max.val >= root.val) return false;
        }
        if(root.right != null) {
            TreeNode right_min = root.right;
            while(right_min.left != null) right_min = right_min.left;
            if(right_min.val <= root.val) return false;
        }
        return true;
    }
}

public class ValidateBinarySearchTree {
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

        if(new Solution().isValidBST(root)) System.out.println("true");
        else System.out.println("false");
    }
}