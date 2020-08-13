package main.java.com.jiang.leetcode100.diameter_of_binary_tree;

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

class Solution {
    private Map<TreeNode, Integer> depthMemo = new HashMap<>();
    private Map<TreeNode, Integer> memo = new HashMap<>();
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        if(memo.containsKey(root)) return memo.get(root);
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        memo.put(root, Math.max(left + right, Math.max(diameterOfBinaryTree(root.left), 
        diameterOfBinaryTree(root.right))));
        return memo.get(root);
    }

    private int getDepth(TreeNode root) {
        if(root == null) return 0;
        if(depthMemo.containsKey(root)) return depthMemo.get(root);
        depthMemo.put(root, Math.max(getDepth(root.left), getDepth(root.right)) + 1);
        return depthMemo.get(root);
    }
}

public class DiameterofBinaryTree {
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

        System.out.println(new Solution().diameterOfBinaryTree(root));
    }
}