package main.java.com.jiang.leetcode100.binary_tree_level_order_traversal;

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

class Solution2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        helper(result, 0, root);
        return result;
    }

    public void helper(List<List<Integer>> result, int depth, TreeNode root) {
        if(root == null) return;
        if(result.size() == depth) result.add(new ArrayList<>());
        result.get(depth).add(root.val);
        helper(result, depth + 1, root.left);
        helper(result, depth + 1, root.right);
    }
}

public class BinaryTreeLevelOrderTraversal2 {
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

        List<List<Integer>> result = new Solution2().levelOrder(root);
        for(List<Integer> temp : result) {
            for(Integer num : temp) System.out.print(num + " ");
            System.out.println();
        }
    }
}