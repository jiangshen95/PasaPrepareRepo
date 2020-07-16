package main.java.com.jiang.leetcode100.maximum_subarray;

import java.util.Arrays;
import java.util.Scanner;

class Solution4 {

    class Status {
        int lsum;
        int rsum;
        int msum;
        int isum;
        public Status(int lsum, int rsum, int msum, int isum) {
            this.lsum = lsum;
            this.rsum = rsum;
            this.msum = msum;
            this.isum = isum;
        }
    }

    public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length - 1).msum;
    }

    public Status pushUp(Status lsub, Status rsub) {
        int lsum = Math.max(lsub.lsum, lsub.isum + rsub.lsum);
        int rsum = Math.max(rsub.rsum, rsub.isum + lsub.rsum);
        int isum = lsub.isum + rsub.isum;
        int msum = Math.max(Math.max(lsub.msum, rsub.msum), lsub.rsum + rsub.lsum);
        return new Status(lsum, rsum, msum, isum);
    }

    public Status helper(int[] nums, int left, int right) {

        if(left >= right) return new Status(nums[left], nums[left], nums[left], nums[left]);
        int mid = (left + right) >> 1;
        Status lsub = helper(nums, left, mid);
        Status rsub = helper(nums, mid + 1, right);

        return pushUp(lsub, rsub);
    }
}

public class MaximumSubarray4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] nums_str = str.split(" ");
        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }

        System.out.println(new Solution4().maxSubArray(nums));
    }
}