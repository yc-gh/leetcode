//https://leetcode.com/problems/subarray-sum-equals-k/

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length, count = 0, sum = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        
        for(int i=0; i<n; i++) {
            sum += nums[i];
            
            //Similar to 2 sum hashed approach
            //targetSum i.e SUM(i,j) = SUM(0,j) - SUM(0,i-1)
            //The SUM(0,i-1) is stored in preSum i.e cachedSum
            //We need to find a cached sum where cachedSum = currentSum - targetSum
            if(sum == k) count++;
            count += preSum.getOrDefault(sum - k, 0);
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        
        return count;
        
    }
}
