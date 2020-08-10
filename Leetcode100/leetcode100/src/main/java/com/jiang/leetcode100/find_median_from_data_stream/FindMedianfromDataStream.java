package main.java.com.jiang.leetcode100.find_median_from_data_stream;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class MedianFinder {

    List<Integer> nums = new LinkedList<>();
    /** initialize your data structure here. */
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(nums.isEmpty()) nums.add(num);
        else {
            int left = 0, right = nums.size() - 1;
            while(left <= right) {
                int mid = left + (right - left) / 2;
                if(nums.get(mid) < num) left  = mid + 1;
                else right = mid - 1; 
            }
            nums.add(left, num);
        }
    }
    
    public double findMedian() {
        int n = nums.size();
        int mid = n / 2;
        if(n % 2 == 0) {
            return (float)(nums.get(mid - 1) + nums.get(mid)) / 2;
        } else {
            return nums.get(mid);
        }
    }
}

public class FindMedianfromDataStream {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());

        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(0, 2);
        for(Integer num : nums) System.out.print(num + " ");
        
    }
}