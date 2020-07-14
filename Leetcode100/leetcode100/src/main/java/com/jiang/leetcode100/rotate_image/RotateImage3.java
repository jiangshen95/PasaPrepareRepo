package main.java.com.jiang.leetcode100.rotate_image;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution3 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n / 2; i++) {
            for(int j = i; j < n - i - 1; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = t;
            }
        }
    }
}

public class RotateImage3 {
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

        new Solution3().rotate(matrix);

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}