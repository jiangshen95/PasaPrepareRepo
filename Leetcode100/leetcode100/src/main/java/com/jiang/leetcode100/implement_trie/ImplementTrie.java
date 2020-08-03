package main.java.com.jiang.leetcode100.implement_trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Trie {

    class TreeNode {
        char ch;
        Map<Character, TreeNode> map;
        boolean isEnd;
        TreeNode(char c) {
            ch = c;
            map = new HashMap<>();
            isEnd = false;
        }
    }

    private TreeNode head;

    /** Initialize your data structure here. */
    public Trie() {
        head = new TreeNode('-');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode cur = head;
        for(int i = 0; i < word.length(); i++) {
            if(!cur.map.containsKey(word.charAt(i))) {
                cur.map.put(word.charAt(i), new TreeNode(word.charAt(i)));
            }
            cur = cur.map.get(word.charAt(i));
        }
        cur.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode cur = head;
        for(int i = 0; i < word.length(); i++) {
            if(!cur.map.containsKey(word.charAt(i))) return false;
            cur = cur.map.get(word.charAt(i));
        }
        return cur.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode cur = head;
        for(int i = 0; i < prefix.length(); i++) {
            if(!cur.map.containsKey(prefix.charAt(i))) return false;
            cur = cur.map.get(prefix.charAt(i));
        }
        return true;
    }
}