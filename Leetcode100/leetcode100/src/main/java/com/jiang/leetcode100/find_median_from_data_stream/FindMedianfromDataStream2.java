package main.java.com.jiang.leetcode100.find_median_from_data_stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class MedianFinder2 {

    PriorityQueue<Integer> low;
    PriorityQueue<Integer> high;
    
    /** initialize your data structure here. */
    public MedianFinder2() {
        low = new PriorityQueue<>((a, b) -> b - a);
        high = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        low.add(num);
        high.add(low.poll());
        if(low.size() < high.size()) {
            low.add(high.poll());
        }
    }
    
    public double findMedian() {
        if(low.size() == high.size()) {
            return (float)(low.peek() + high.peek()) / 2;
        } else {
            return low.peek();
        }
    }
}

public class FindMedianfromDataStream2 {
    public static void main(String[] args) {
        MedianFinder2 medianFinder = new MedianFinder2();
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