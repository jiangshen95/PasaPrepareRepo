package main.java.com.jiang.leetcode100.construct_binary_tree_from_preorder_and_inorder_traversal;

import java.util.HashMap;
import java.util.Map;
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, Integer.MAX_VALUE);
    }

    int pre = 0;
    int in = 0;
    public TreeNode helper(int[] preorder, int[] inorder, int stop) {
        if(pre == preorder.length) return null;
        if(inorder[in] == stop) {
            in++;
            return null;
        }
        TreeNode root = new TreeNode(preorder[pre++]);
        root.left = helper(preorder, inorder, root.val);
        root.right = helper(preorder, inorder, stop);
        return root;
    }
}

public class ConstructBinaryTreefromPreorderandInorderTraversal4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        scanner.close();
        String[] nums_str1 = str1.split(" ");
        String[] nums_str2 = str2.split(" ");
        int[] preorder = new int[nums_str1.length];
        int[] inorder = new int[nums_str2.length];
        for(int i = 0; i < nums_str1.length; i++) {
            preorder[i] = Integer.parseInt(nums_str1[i]);
            inorder[i] = Integer.parseInt(nums_str2[i]);
        }
        TreeNode root = new Solution4().buildTree(preorder, inorder);
        printTree(root);
    }

    public static void printTree(TreeNode root) {
        if(root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}