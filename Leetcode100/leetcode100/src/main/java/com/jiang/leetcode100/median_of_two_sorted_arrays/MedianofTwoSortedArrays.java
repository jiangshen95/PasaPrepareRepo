package main.java.com.jiang.leetcode100.median_of_two_sorted_arrays;

import java.util.Scanner;

/**
 * 复杂度不符合要求
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length, n2 = nums2.length;
        int mid = (n1 + n2) / 2;
        
        int n = 0;
        int i = 0, j = 0;
        int pre = 0, num = 0;
        while(n <= mid) {
            pre = num;
            if(j >= n2 || (i < n1 && nums1[i] <= nums2[j])) {
                num = nums1[i];
                i++;
            } else {
                num = nums2[j];
                j++;
            }
            n++;
        }

        double result = 0;
        if((n1 + n2) % 2 == 0) result = (pre + num) / 2.0;
        else result = num;

        return result;
    }
}

public class MedianofTwoSortedArrays {
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

        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));

    }
}