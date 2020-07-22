package main.java.com.jiang.leetcode100.binary_tree_inorder_traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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

class Solution4 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<Integer> status = new ArrayDeque<>();

        stack.push(root);
        status.push(0);

        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            int cur_statu = status.pop();
            if(cur_statu == 0) {
                if(cur.right != null) {
                    stack.push(cur.right);
                    status.push(0);
                }
                stack.push(cur);
                status.push(1);
                if(cur.left != null) {
                    stack.push(cur.left);
                    status.push(0);
                }
            } else {
                result.add(cur.val);
            }
        }
        return result;
    }
}

public class BinaryTreeInorderTraversal4 {
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

        List<Integer> result = new Solution4().inorderTraversal(root);
        for(Integer num : result) System.out.print(num + " ");
    }
}