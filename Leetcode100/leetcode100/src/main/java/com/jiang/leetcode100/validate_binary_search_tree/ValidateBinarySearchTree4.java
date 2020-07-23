package main.java.com.jiang.leetcode100.validate_binary_search_tree;

import java.util.ArrayDeque;
import java.util.Deque;
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

class Solution4 {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        TreeNode cur = root;
        long pre = Long.MIN_VALUE;

        while(cur != null) {
            if(cur.left == null) {
                if(cur.val <= pre) return false;
                pre = cur.val;
                cur = cur.right;
            } else {
                TreeNode pre_node = cur.left;
                while(pre_node.right != null && pre_node.right != cur) {
                    pre_node = pre_node.right;
                }
                if(pre_node.right == null) {
                    pre_node.right = cur;
                    cur = cur.left;
                } else if(pre_node.right == cur) {
                    if(cur.val <= pre) return false;
                    pre = cur.val;
                    pre_node.right = null;
                    cur =cur.right;
                }
            }
        }
        return true;
    }
}

public class ValidateBinarySearchTree4 {
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

        if(new Solution4().isValidBST(root)) System.out.println("true");
        else System.out.println("false");
    }
}