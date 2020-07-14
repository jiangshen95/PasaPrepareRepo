package main.java.com.jiang.leetcode100.group_anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            Map<Character, Integer> m = new HashMap<>();
            for(int j = 0; j < strs[i].length(); j++) {
                if(!m.containsKey(strs[i].charAt(j))) {
                    m.put(strs[i].charAt(j), 1);
                } else {
                    int val = m.get(strs[i].charAt(j));
                    m.put(strs[i].charAt(j), val + 1);
                }
            }
            if(map.containsKey(m)) {
                List<String> temp = map.get(m);
                temp.add(strs[i]);
                map.put(m, temp);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                map.put(m, temp);
            }
        }

        List<List<String>> result = new ArrayList<>(map.values());
        return result;
    }
}

public class GroupAnagrams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputs = scanner.nextLine();
        scanner.close();

        String[] strs = inputs.split(" ");
        List<List<String>> result = new Solution().groupAnagrams(strs);
        for(List<String> line : result) {
            for(String str : line) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
}