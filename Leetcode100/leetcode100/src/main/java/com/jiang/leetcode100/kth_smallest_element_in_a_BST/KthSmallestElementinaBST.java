package main.java.com.jiang.leetcode100.kth_smallest_element_in_a_BST;

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
    public int kthSmallest(TreeNode root, int k) {
        int leftNum = getNodesNum(root.left);
        if(leftNum + 1 == k) return root.val;
        else if(leftNum + 1 < k) return kthSmallest(root.right, k - leftNum - 1);
        else return kthSmallest(root.left, k);
    }

    private int getNodesNum(TreeNode root) {
        if(root == null) return 0;
        return 1 + getNodesNum(root.left) + getNodesNum(root.right);
    }
}

public class KthSmallestElementinaBST {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int k = scanner.nextInt();
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

        System.out.println(new Solution().kthSmallest(root, k));
    }
}