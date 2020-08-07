package main.java.com.jiang.leetcode100.search_a_2D_matrix_II;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m <= 0) return false;
        int n = matrix[0].length;
        
        int begin = 0, end = n - 1;
        while(begin <= end) {
            int mid = begin + (end - begin) / 2;
            if(matrix[0][mid] == target) return true;
            else if(matrix[0][mid] < target) begin = mid + 1;
            else end = mid - 1;
        }

        if(end < 0) return false;

        int pos = end;

        for(int j = 0; j <= pos; j++) {
            begin = 0;
            end = m - 1;
            while(begin <= end) {
                int mid = begin + (end - begin) / 2;
                if(matrix[mid][j] == target) return true;
                else if(matrix[mid][j] < target) begin = mid + 1;
                else end = mid - 1;
            }
        }
        return false;
    }
}

public class Searcha2DMatrixII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();
        while(!scanner.hasNext("#")) {
            inputs.add(scanner.nextLine());
        }
        scanner.nextLine();
        int target = scanner.nextInt();
        scanner.close();

        int[][] matrix = new int[inputs.size()][inputs.get(0).split(" ").length];
        for(int i = 0; i < inputs.size(); i++) {
            String[] nums_str = inputs.get(i).split(" ");
            int[] nums = new int[nums_str.length];
            for(int j = 0; j < nums_str.length; j++) nums[j] = Integer.parseInt(nums_str[j]);
            matrix[i] = nums;
        }

        if(new Solution().searchMatrix(matrix, target)) System.out.println("true");
        else System.out.println("false");
    }
}