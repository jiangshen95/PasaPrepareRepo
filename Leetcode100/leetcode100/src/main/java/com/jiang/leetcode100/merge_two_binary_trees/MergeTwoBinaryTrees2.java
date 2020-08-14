package main.java.com.jiang.leetcode100.merge_two_binary_trees;

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

class Solution2 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null) return t2;
        Deque<TreeNode[]> stack = new ArrayDeque<>();
        stack.push(new TreeNode[]{t1, t2});
        while(!stack.isEmpty()) {
            TreeNode[] top = stack.pop();
            if(top[0] == null || top[1] == null) continue;
            top[0].val += top[1].val;
            if(top[0].left == null) top[0].left = top[1].left;
            else {
                stack.push(new TreeNode[]{top[0].left, top[1].left});
            }
            if(top[0].right == null) top[0].right = top[1].right;
            else {
                stack.push(new TreeNode[]{top[0].right, top[1].right});
            }
        }
        return t1;
    }
}

public class MergeTwoBinaryTrees2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        scanner.close();

        TreeNode t1 = initTree(str1);
        TreeNode t2 = initTree(str2);

        TreeNode root = new Solution2().mergeTrees(t1, t2);
        printTree(root);
    }

    private static TreeNode initTree(String str) {
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

        return root;
    }

    public static void printTree(TreeNode root) {
        if(root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}