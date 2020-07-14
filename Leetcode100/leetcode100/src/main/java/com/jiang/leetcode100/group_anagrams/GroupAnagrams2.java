package main.java.com.jiang.leetcode100.group_anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            char[] chs = strs[i].toCharArray();
            Arrays.sort(chs);
            String key = String.valueOf(chs);

            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }
}

public class GroupAnagrams2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputs = scanner.nextLine();
        scanner.close();

        String[] strs = inputs.split(" ");
        List<List<String>> result = new Solution2().groupAnagrams(strs);
        for(List<String> line : result) {
            for(String str : line) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
}