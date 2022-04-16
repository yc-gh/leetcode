//https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int l = 0, n = nums.length, maxLen = 0;
        
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        
        for(int r=0; r<n; r++) {
            
            while(!maxDeque.isEmpty() && maxDeque.peekLast() < nums[r]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(nums[r]);
            
            while(!minDeque.isEmpty() && minDeque.peekLast() > nums[r]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(nums[r]);
            
            
            while((maxDeque.peekFirst() - minDeque.peekFirst()) > limit) {
                if(nums[l] == maxDeque.peekFirst()) maxDeque.pollFirst();
                if(nums[l] == minDeque.peekFirst()) minDeque.pollFirst();
                l++;
            }
            
            maxLen = Math.max(maxLen, r - l + 1);
            
        }
        
        return maxLen;
    }
}
