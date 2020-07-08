package main.java.com.jiang.leetcode100.generate_parentheses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import org.graalvm.compiler.graph.Node;

/**
 * 广度优先遍历
 * 消除递归
 */
class Solution4 {

    class Node{
        String str;
        int left;
        int right;

        public Node(String str, int left, int right) {
            this.str = str;
            this.left = left;
            this.right = right;
        }
    }

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node("", 0, 0));

        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            if(cur.left == n && cur.right == n) {
                result.add(cur.str);
            }
            if(cur.left < n) {
                queue.offer(new Node(cur.str + '(', cur.left + 1, cur.right));
            }
            if(cur.left > cur.right) {
                queue.offer(new Node(cur.str + ')', cur.left, cur.right + 1));
            }
        }

        return result;
    }
}

public class GenerateParentheses4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        
        List<String> result = new Solution4().generateParenthesis(n);
        for(String str : result) {
            System.out.println(str);
        }
    }
}