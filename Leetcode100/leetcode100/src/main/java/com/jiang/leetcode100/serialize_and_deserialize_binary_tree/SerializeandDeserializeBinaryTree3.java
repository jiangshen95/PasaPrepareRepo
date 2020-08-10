package main.java.com.jiang.leetcode100.serialize_and_deserialize_binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
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

class Codec3 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        String result = "";
        while(!queue.isEmpty()) {

            TreeNode cur = queue.poll();
            if(cur == null) result += "#,";
            else {
                result += cur.val + ",";
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;

        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        for(int i = 1; i < nodes.length; i += 2) {
            TreeNode cur = queue.poll();
            if(nodes[i].equals("#")) cur.left = null;
            else {
                cur.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(cur.left);
            }
            if(nodes[i + 1].equals("#")) cur.right = null;
            else {
                cur.right = new TreeNode(Integer.parseInt(nodes[i + 1]));
                queue.add(cur.right);
            }
        }
        return root;
    }
}

public class SerializeandDeserializeBinaryTree3 {
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

        Codec3 codec = new Codec3();
        String code = codec.serialize(root);
        System.out.println(code);
        TreeNode cur = codec.deserialize(code);
        printTree(cur);
    }

    private static void printTree(TreeNode root) {
        if(root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}