package main.java.com.jiang.leetcode100.find_the_duplicate_number;

import java.util.Scanner;

class Solution2 {
    public int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        int max_bit = 31;
        while((n >> max_bit) == 0) max_bit--;
        int result = 0;
        for(int i = 0; i <= max_bit; i++) {
            int x = 0, y = 0;
            for(int j = 0; j <= n; j++) {
                if(((nums[j] >> i) & 1) == 1) x++;
                if(j > 0 && (((j >> i) & 1) == 1)) y++;
            }
            if(x > y) result |= (1 << i);
        }
        return result;
    }
}

public class FindtheDuplicateNumber2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) nums[i] = Integer.parseInt(nums_str[i]);

        System.out.println(new Solution2().findDuplicate(nums));
    }
}