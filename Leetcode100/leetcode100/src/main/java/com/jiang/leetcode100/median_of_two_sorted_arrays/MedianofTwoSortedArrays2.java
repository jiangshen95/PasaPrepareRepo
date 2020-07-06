package main.java.com.jiang.leetcode100.median_of_two_sorted_arrays;

import java.util.Scanner;

class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            m = nums1.length;
            n = nums2.length;
        }

        int begin = 0, end = m;
        while(begin <= end) {
            int i = (begin + end) / 2;
            int j = (m + n + 1) / 2 - i;
            if(i < end && nums2[j - 1] > nums1[i]) {
                begin = i + 1;
            } else if(i > begin && nums1[i - 1] > nums2[j]) {
                end = i - 1;
            } else {
                int max_left = 0;
                if(i == 0) max_left = nums2[j - 1];
                else if(j == 0) max_left = nums1[i - 1];
                else max_left = Math.max(nums1[i - 1], nums2[j - 1]);

                if((m + n) % 2 == 1) return max_left;

                int max_right = 0;
                if(i == m) max_right = nums2[j];
                else if(j == n) max_right = nums1[i];
                else max_right = Math.min(nums1[i], nums2[j]);

                return (max_left + max_right) / 2.0;
            }
        }
        return 0;
    }
}

public class MedianofTwoSortedArrays2 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        String str2 = scan.nextLine();
        scan.close();

        String[] snums1 = str1.split(" ");
        String[] snums2 = str2.split(" ");

        int[] nums1 = new int[snums1.length];
        int[] nums2 = new int[snums2.length];

        for(int i = 0; i < snums1.length; i++) {
            nums1[i] = Integer.parseInt(snums1[i]);
        }

        for(int i = 0; i < snums2.length; i++) {
            nums2[i] = Integer.parseInt(snums2[i]);
        }

        System.out.println(new Solution2().findMedianSortedArrays(nums1, nums2));

    }
}