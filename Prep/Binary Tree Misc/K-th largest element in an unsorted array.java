//https://leetcode.com/problems/kth-largest-element-in-an-array/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<nums.length; i++) {
            if(pq.size() < k) {
                pq.offer(nums[i]);
            }
            else {
                if(nums[i] > pq.peek()) {
                    pq.poll();
                    pq.offer(nums[i]);
                }
            }
        }
        
        return pq.peek();
    }
}
