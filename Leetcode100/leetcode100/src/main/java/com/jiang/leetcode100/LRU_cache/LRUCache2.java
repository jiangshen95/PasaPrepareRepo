package main.java.com.jiang.leetcode100.LRU_cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int k, int v) {
            key = k;
            value = v;
        }
    }

    private int capacity;
    private Map<Integer, DLinkedNode> map;
    DLinkedNode head, tail;
    private int size;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        size = 0;

        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        DLinkedNode node = map.get(key);
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            DLinkedNode node = map.get(key);
            node.value = value;
            moveToHead(node);
            return;
        }
        if(size < capacity) {
            DLinkedNode node = new DLinkedNode(key, value);
            map.put(key, node);
            addToHead(node);
            size++;
        } else {
            DLinkedNode node = removeTail();
            map.remove(node.key);
            size--;
            put(key, value);
        }
    }

    private void addToHead(DLinkedNode node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    private void removeNode(DLinkedNode node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode node = tail.pre;
        removeNode(node);
        return node;
    }
}