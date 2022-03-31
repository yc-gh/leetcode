//https://leetcode.com/problems/continuous-subarray-sum/

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) return false;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        
        int preSum = 0;
        
        for(int i=0; i<nums.length; i++) {
            preSum += nums[i];
            
            if(k != 0) preSum = preSum % k;
            
            if(!map.containsKey(preSum)) {
                map.put(preSum, i);
            }
            else {
                int lastSeenIndex = map.get(preSum);
                if(i - lastSeenIndex > 1) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
