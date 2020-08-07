package main.java.com.jiang.leetcode100.search_a_2D_matrix_II;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m <= 0) return false;
        int n = matrix[0].length;
        
        return searchRect(matrix, 0, m - 1, 0, n - 1, target);
    }

    private boolean searchRect(int[][] matrix, int up, int down, int left, int right, int target) {
        if(up > down || left > right) return false;
        int mid = left + (right - left) / 2;
        int i = up, j = down;
        while(i <= j) {
            int m = i + (j - i) / 2;
            if(matrix[m][mid] == target) return true;
            else if(matrix[m][mid] < target) i = m + 1;
            else j = m - 1;
        }
        return searchRect(matrix, up, j, mid + 1, right, target) ||
            searchRect(matrix, j + 1, down, left, mid - 1, target);
    }
}

public class Searcha2DMatrixII2 {
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

        if(new Solution2().searchMatrix(matrix, target)) System.out.println("true");
        else System.out.println("false");
    }
}