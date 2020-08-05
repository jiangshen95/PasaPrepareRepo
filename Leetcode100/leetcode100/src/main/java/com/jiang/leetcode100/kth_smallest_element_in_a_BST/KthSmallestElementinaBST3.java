package main.java.com.jiang.leetcode100.kth_smallest_element_in_a_BST;

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

class Solution3 {
    public int kthSmallest(TreeNode root, int k) {
        TreeNode cur = root;

        int count = 0;
        while(cur != null) {
            if(cur.left == null) {
                if(++count == k) return cur.val;
                cur = cur.right;
            } else {
                TreeNode pre = cur.left;
                while(pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if(pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else if(pre.right == cur) {
                    pre.right = null;
                    if(++count == k) return cur.val;
                    cur = cur.right;
                }
            }
        }
        return 0;
    }
}

public class KthSmallestElementinaBST3 {
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

        System.out.println(new Solution3().kthSmallest(root, k));
    }
}