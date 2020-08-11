package main.java.com.jiang.leetcode100.house_robber_III;

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
    public int rob(TreeNode root) {
        Map<TreeNode, Integer> memo1 = new HashMap<>();
        Map<TreeNode, Integer> memo2 = new HashMap<>();
        return helper(root, false, memo1, memo2);
    }

    private int helper(TreeNode root, boolean parent_used, 
        Map<TreeNode, Integer> memo1, Map<TreeNode, Integer> memo2) {

        if(root == null) return 0;
        int result = 0;
        if(parent_used) {
            if(memo1.containsKey(root)) result = memo1.get(root);
            else {
                result = helper(root.left, false, memo1, memo2) + 
                    helper(root.right, false, memo1, memo2);
                memo1.put(root, result);
            }
        } else {
            if(memo2.containsKey(root)) result = memo2.get(root);
            else {
                int use = root.val + helper(root.left, true, memo1, memo2) + 
                    helper(root.right, true, memo1, memo2);
                int unuse = helper(root.left, false, memo1, memo2) + 
                    helper(root.right, false, memo1, memo2);
                result = Math.max(use, unuse);
                memo2.put(root, result);
            }
            
        }
        return result;
    }
}

public class HouseRobberIII {
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

        System.out.println(new Solution().rob(root));
    }
}