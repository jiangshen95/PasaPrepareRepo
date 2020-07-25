package main.java.com.jiang.leetcode100.construct_binary_tree_from_preorder_and_inorder_traversal;

import java.util.ArrayDeque;
import java.util.Deque;
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length <= 0) return null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        int i = 0, j = 0;
        TreeNode root = new TreeNode(preorder[i], null, null);
        i++;
        TreeNode cur = root;
        boolean isRight = false;
        stack.push(root);
        while(i < preorder.length) {
            if(!stack.isEmpty() && inorder[j] == stack.getFirst().val) {
                cur = stack.pop();
                j++;
                isRight = true;
            } else {
                if(isRight) {
                    cur.right = new TreeNode(preorder[i], null, null);
                    i++;
                    cur = cur.right;
                    stack.push(cur);
                    isRight = false;
                } else {
                    cur.left = new TreeNode(preorder[i], null, null);
                    cur = cur.left;
                    stack.push(cur);
                    i++;
                }
            }
        }
        return root;
    }
}

public class ConstructBinaryTreefromPreorderandInorderTraversal2 {
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
        TreeNode root = new Solution2().buildTree(preorder, inorder);
        printTree(root);
    }

    public static void printTree(TreeNode root) {
        if(root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}