package design;

import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    private double median;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        if(minHeap.size() == 0) {
            minHeap.add(num);
        } else {
            median = findMedian();
            if (minHeap.size() > maxHeap.size()) {
                if (num < median) {
                    maxHeap.add(num);
                } else {
                    maxHeap.add(minHeap.remove());
                    minHeap.add(num);
                }
            } else {
                if (num < median) {
                    maxHeap.add(num);
                    minHeap.add(maxHeap.remove());
                } else {
                    minHeap.add(num);
                }
            }
        }
    }

    public double findMedian() {
        int size = minHeap.size() + maxHeap.size();
        if (size%2 != 0) {
            median = minHeap.peek();
        } else {
            median = ((double) minHeap.peek() + maxHeap.peek())/2;
        }
        return median;
    }
}
