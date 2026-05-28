package day_060_date_2026_05_29.priorityqueue;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    // TODO: Declare your two PriorityQueues here
    // Hint: One max-heap for the lower half, one min-heap for the upper half.
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public FindMedianFromDataStream() {
        // TODO: Initialize your heaps here
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // TODO: Implement number insertion and balancing logic
        maxHeap.add(num);
        minHeap.add(num);
    }

    public double findMedian() {
        // TODO: Implement median calculation logic
        double mean = (double) (minHeap.peek()+ maxHeap.peek())/2;
        return mean;
    }

    public static void main(String[] args) {
        FindMedianFromDataStream finder = new FindMedianFromDataStream();

        // Test Case 1
        finder.addNum(1);
        finder.addNum(2);
        System.out.println("Median after [1, 2]: " + finder.findMedian()); // Expected: 1.5

        // Test Case 2
        finder.addNum(3);
        System.out.println("Median after [1, 2, 3]: " + finder.findMedian()); // Expected: 2.0
    }
}
