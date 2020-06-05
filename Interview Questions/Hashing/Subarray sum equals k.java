//https://leetcode.com/problems/subarray-sum-equals-k/

class Solution {
    // Looking for sum[j]-sum[i-1] == k
    // Instead check for sum[j]-k == sum[i-1]
    // If found, increase count by number of times ^ this was found
    public int subarraySum(int[] nums, int k) {
        int n = nums.length, count=0, sum=0;
        Map<Integer,Integer> preSum = new HashMap<>();
        preSum.put(0,1);
        for(int i=0; i<n; i++)
        {
            sum += nums[i];
            if(preSum.containsKey(sum-k))
            {
                count += preSum.get(sum-k);
            }
            preSum.put(sum, preSum.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
