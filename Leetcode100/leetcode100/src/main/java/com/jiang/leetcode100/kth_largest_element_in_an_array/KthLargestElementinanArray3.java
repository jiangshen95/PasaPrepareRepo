package main.java.com.jiang.leetcode100.kth_largest_element_in_an_array;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Solution3 {
    int heapSize;
    public int findKthLargest(int[] nums, int k) {
        int result = 0;
        buildMaxHeap(nums);
        for(int i = 0; i < k; i++) {
            result = removeMax(nums);
        }
        return result;
    }

    private void maxHeapShifDown(int[] heap, int start) {
        int i = start, j = start * 2 + 1, temp = heap[start];
        while(j < heapSize) {
            if(j < heapSize - 1 && heap[j + 1] > heap[j]) j++;
            if(temp >= heap[j]) break;
            else if(temp < heap[j]) {
                heap[i] = heap[j];
                i = j;
                j = i * 2 + 1;
            } 
        }
        heap[i] = temp;
    }

    private void buildMaxHeap(int[] nums) {
        heapSize = nums.length;
        for(int i = (heapSize - 2) / 2; i >= 0; i--) {
            maxHeapShifDown(nums, i);
        }
    }

    private int removeMax(int[] heap) {
        int x = heap[0];
        heap[0] = heap[heapSize - 1];
        heapSize--;
        maxHeapShifDown(heap, 0);
        return x;
    }
}

public class KthLargestElementinanArray3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int k = scanner.nextInt();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) nums[i] = Integer.parseInt(nums_str[i]);

        System.out.println(new Solution3().findKthLargest(nums, k));
    }
}