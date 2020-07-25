package main.java.com.jiang.leetcode100.construct_binary_tree_from_preorder_and_inorder_traversal;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length);
    }

    public TreeNode helper(int[] preorder, int begin1, int end1, 
        int[] inorder, int begin2, int end2) {
        
        if(begin1 > end1) return null;
        TreeNode root = new TreeNode(preorder[begin1]);
        int index = begin2;
        for(int i = begin2; i <= end2; i++) {
            if(inorder[i] == preorder[begin1]) {
                index = i;
                break;
            }
        }
        root.left = helper(preorder, begin1 + 1, begin1 + index - begin2, 
            inorder, begin2, index - 1);
        root.right = helper(preorder, begin1 + index - begin2 + 1, end1, 
            inorder, index + 1, end2);
        return root;
    }
}

public class ConstructBinaryTreefromPreorderandInorderTraversal {
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
        TreeNode root = new Solution().buildTree(preorder, inorder);
        printTree(root);
    }

    public static void printTree(TreeNode root) {
        if(root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}