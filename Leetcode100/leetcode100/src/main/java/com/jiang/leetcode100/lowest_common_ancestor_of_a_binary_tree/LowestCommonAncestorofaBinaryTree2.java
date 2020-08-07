package main.java.com.jiang.leetcode100.lowest_common_ancestor_of_a_binary_tree;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        parent.put(root, null);
        while(!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode cur = queue.poll();
            if(cur.left != null) {
                parent.put(cur.left, cur);
                queue.add(cur.left);
            }
            if(cur.right != null) {
                parent.put(cur.right, cur);
                queue.add(cur.right);
            }
        }

        Set<TreeNode> ancestors = new HashSet<>();
        while(q != null) {
            ancestors.add(q);
            q = parent.get(q);
        }

        while(!ancestors.contains(p)) {
            p = parent.get(p);
        }

        return p;
    }
}

public class LowestCommonAncestorofaBinaryTree2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int p = scanner.nextInt();
        int q = scanner.nextInt();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new  int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }

        TreeNode root = new TreeNode(nums[0], null, null);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        TreeNode pnode = null, qnode = null;
        for(int i = 1; i < nums.length; i += 2) {
            TreeNode cur = queue.poll();
            if(cur.val == p) pnode = cur;
            else if(cur.val == q) qnode = cur;
            if(nums[i] != -1) {
                cur.left = new TreeNode(nums[i], null, null);
                queue.add(cur.left);
            }
            if(nums[i + 1] != -1) {
                cur.right = new TreeNode(nums[i + 1], null, null);
                queue.add(cur.right);
            }
        }
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur.val == p) pnode = cur;
            else if(cur.val == q) qnode = cur;
        }

        System.out.println(new Solution2().lowestCommonAncestor(root, pnode, qnode).val);
    }
}