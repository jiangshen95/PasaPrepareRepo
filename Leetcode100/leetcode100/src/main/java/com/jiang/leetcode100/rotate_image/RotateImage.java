package main.java.com.jiang.leetcode100.rotate_image;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        reverse(matrix);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
    }


    public void reverse(int[][] matrix) {
        int begin = 0;
        int end = matrix.length - 1;
        while(begin < end) {
            for(int i = 0; i < matrix.length; i++) {
                int t = matrix[begin][i];
                matrix[begin][i] = matrix[end][i];
                matrix[end][i] = t;
            }
            begin++;
            end--;
        }
    }
}

public class RotateImage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();
        while(!scanner.hasNext("#")) {
            inputs.add(scanner.nextLine());
        }
        scanner.close();

        int[][] matrix = new int[inputs.size()][inputs.size()];
        for(int i = 0; i < inputs.size(); i++) {
            String[] line = inputs.get(i).split(" ");
            for(int j = 0; j < line.length; j++) {
                matrix[i][j] = Integer.valueOf(line[j]);
            }
        }

        new Solution().rotate(matrix);

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}