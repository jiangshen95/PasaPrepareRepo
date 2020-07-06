package main.java.com.jiang.leetcode100.median_of_two_sorted_arrays;

import java.util.Scanner;

class Solution3 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int m = nums1.length;
        int n = nums2.length;
        if((m + n) % 2 == 1) {
            return getKthElement(nums1, nums2, (m + n) / 2 + 1);
        } else {
            return (getKthElement(nums1, nums2, (m + n) / 2) + 
                getKthElement(nums1, nums2, (m + n) / 2 + 1)) / 2.0;
        }

    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int index1 = 0, index2 = 0;
        while(true) {
            if(index1 == m) return nums2[index2 + k - 1];
            if(index2 == n) return nums1[index1 + k - 1];
            if(k == 1) return Math.min(nums1[index1], nums2[index2]);

            int mid = k / 2;
            int newindex1 = Math.min(index1 + mid, m) - 1;
            int newindex2 = Math.min(index2 + mid, n) - 1;
            if(nums1[newindex1] <= nums2[newindex2]) {
                k -= (newindex1 - index1) + 1;
                index1 = newindex1 + 1;
            } else {
                k -= (newindex2 - index2) + 1;
                index2 = newindex2 + 1;
            }
        }
    }
}

public class MedianofTwoSortedArrays3 {
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

        System.out.println(new Solution3().findMedianSortedArrays(nums1, nums2));

    }
}