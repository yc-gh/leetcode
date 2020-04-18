// https://leetcode.com/problems/find-median-from-data-stream/

// A bst optimised solution is also possible TODO

// Two heaps log(logn) (logn ?)
class MedianFinder {

    PriorityQueue<Integer> maxHeap, minHeap;
    
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a,b)->b-a);
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(maxHeap.size()<minHeap.size()) maxHeap.offer(minHeap.poll());
    }
    
    public double findMedian() {
        if(maxHeap.size()==minHeap.size())
        {
            double left = maxHeap.peek();
            double right = minHeap.peek();
            return left + (right-left)/2;
        }
        else
        {
            return maxHeap.peek();
        }
    }
}