//https://leetcode.com/problems/kth-largest-element-in-a-stream/

class KthLargest {
    PriorityQueue<Integer> minHeap;
    int limit;
    
    public KthLargest(int k, int[] nums) {
        limit = k;
        minHeap = new PriorityQueue<>(k);
        
        for(int n : nums) add(n);
    }
    
    public int add(int val) {
        if(minHeap.size() < limit) minHeap.offer(val);
        else if(val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }
}
