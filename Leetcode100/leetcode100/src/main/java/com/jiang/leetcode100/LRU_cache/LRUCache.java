package main.java.com.jiang.leetcode100.LRU_cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class LRUCache {
    private List<Integer> list;
    private int capacity;
    private Map<Integer, Integer> map;
    public LRUCache(int capacity) {
        list = new LinkedList<>();
        this.capacity = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        int value = map.get(key);
        list.remove(Integer.valueOf(key));
        list.add(key);
        return value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            map.put(key, value);
            list.remove(Integer.valueOf(key));
            list.add(key);
            return;
        }
        if(list.size() < capacity) {
            map.put(key, value);
            list.add(key);
        } else {
            map.remove(list.remove(0));
            map.put(key, value);
            list.add(key);
        }
    }
}