//https://leetcode.com/problems/subarray-sums-divisible-by-k/

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] map = new int[k];
        map[0] = 1;
        
        int sum = 0, count = 0;
        
        for(int n : nums) {
            sum = (sum + n) % k;
            if(sum < 0) sum += k;
            count += map[sum];
            map[sum]++;
        }
        
        return count;
    }
}
