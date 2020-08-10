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

class Codec4 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "X";
        String left = "(" + serialize(root.left) + ")";
        String right = "(" + serialize(root.right) + ")";
        return left + root.val + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("X")) return null;
        if(data.charAt(0) != '(') return new TreeNode(Integer.parseInt(data));
        int count = 0;
        TreeNode left, right;
        int i = 0;
        for(; i < data.length(); i++) {
            if(data.charAt(i) == '(') count++;
            else if(data.charAt(i) == ')') count--;
            if(count == 0) {
                break;
            }
        }
        left = deserialize(data.substring(1, i));
        int val = 0, symbol = 1;
        while(data.charAt(++i) != '(') {
            if(data.charAt(i) == '-') {
                symbol = -1;
                continue;
            }
            val = val * 10 + (data.charAt(i) - '0');
        }
        val *= symbol;
        TreeNode root = new TreeNode(val);
        right = deserialize(data.substring(i + 1, data.length() - 1));
        root.left = left;
        root.right = right;
        return root;
    }
}

public class SerializeandDeserializeBinaryTree4 {
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

        Codec4 codec = new Codec4();
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