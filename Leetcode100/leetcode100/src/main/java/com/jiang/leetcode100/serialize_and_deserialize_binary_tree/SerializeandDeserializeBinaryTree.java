package main.java.com.jiang.leetcode100.serialize_and_deserialize_binary_tree;

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

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        String result = "";
        while(!queue.isEmpty()) {
            List<TreeNode> temp = new ArrayList<>();
            for(TreeNode node : queue) {
                if(node == null) {
                    result += "#_";
                } else {
                    result += node.val + "_";
                    temp.add(node.left);
                    temp.add(node.right);
                }
            }
            result += ":";
            queue = temp;
        }
        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        String[] levels = data.split(":");
        List<TreeNode> nodes = new ArrayList<>();
        TreeNode root = new TreeNode(Integer.parseInt(levels[0].split("_")[0]));
        nodes.add(root);
        for(int i = 1; i < levels.length; i++) {
            String[] level = levels[i].split("_");
            int index = 0;
            List<TreeNode> temp = new ArrayList<>();
            for(TreeNode node : nodes) {
                if(level[index].equals("#")) node.left = null;
                else {
                    node.left = new TreeNode(Integer.parseInt(level[index]));
                    temp.add(node.left);
                }
                if(level[index + 1].equals("#")) node.right = null;
                else {
                    node.right = new TreeNode(Integer.parseInt(level[index + 1]));
                    temp.add(node.right);
                }
                index += 2;
            }
            nodes = temp;
        }
        return root;
    }
}

public class SerializeandDeserializeBinaryTree {
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

        Codec codec = new Codec();
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