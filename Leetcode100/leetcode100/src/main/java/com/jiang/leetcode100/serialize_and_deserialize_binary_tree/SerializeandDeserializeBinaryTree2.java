package main.java.com.jiang.leetcode100.serialize_and_deserialize_binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
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

class Codec2 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return dfs_serialize(root, "");
    }

    private String dfs_serialize(TreeNode root, String result) {
        if(root == null) result += "#,";
        else {
            result += root.val + ",";
            result = dfs_serialize(root.left, result);
            result = dfs_serialize(root.right, result);
        }
        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> data_list = new LinkedList<>(Arrays.asList(data.split(",")));
        return dfs_deserialize(data_list);
    }

    private TreeNode dfs_deserialize(List<String> data_list) {
        if(data_list.get(0).equals("#")) {
            data_list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(data_list.get(0)));
        data_list.remove(0);
        root.left = dfs_deserialize(data_list);
        root.right = dfs_deserialize(data_list);
        return root;
    }
}

public class SerializeandDeserializeBinaryTree2 {
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

        Codec2 codec = new Codec2();
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