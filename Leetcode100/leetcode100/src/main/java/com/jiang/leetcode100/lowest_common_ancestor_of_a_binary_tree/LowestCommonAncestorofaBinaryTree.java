package main.java.com.jiang.leetcode100.lowest_common_ancestor_of_a_binary_tree;

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(isOffsprint(root.left, p) && isOffsprint(root.left, q)) {
            return lowestCommonAncestor(root.left, p, q);
        } else if(isOffsprint(root.right, p) && isOffsprint(root.right, q)) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    private boolean isOffsprint(TreeNode root, TreeNode cur) {
        if(root == null) return false;
        if(root == cur) return true;
        return isOffsprint(root.left, cur) || isOffsprint(root.right, cur);
    }
}

public class LowestCommonAncestorofaBinaryTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int p = scanner.nextInt();
        int q = scanner.nextInt();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new  int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }

        TreeNode root = new TreeNode(nums[0], null, null);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        TreeNode pnode = null, qnode = null;
        for(int i = 1; i < nums.length; i += 2) {
            TreeNode cur = queue.poll();
            if(cur.val == p) pnode = cur;
            else if(cur.val == q) qnode = cur;
            if(nums[i] != -1) {
                cur.left = new TreeNode(nums[i], null, null);
                queue.add(cur.left);
            }
            if(nums[i + 1] != -1) {
                cur.right = new TreeNode(nums[i + 1], null, null);
                queue.add(cur.right);
            }
        }
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur.val == p) pnode = cur;
            else if(cur.val == q) qnode = cur;
        }

        System.out.println(new Solution().lowestCommonAncestor(root, pnode, qnode).val);
    }
}