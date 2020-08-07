package main.java.com.jiang.leetcode100.search_a_2D_matrix_II;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution3 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m <= 0) return false;
        int n = matrix[0].length;
        
        int row = m - 1, col = 0;
        while(row >= 0 && col < n) {
            if(matrix[row][col] > target) row--;
            else if(matrix[row][col] < target) col++;
            else return true;
        }
        return false;
    }
}

public class Searcha2DMatrixII3 {
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

        if(new Solution3().searchMatrix(matrix, target)) System.out.println("true");
        else System.out.println("false");
    }
}