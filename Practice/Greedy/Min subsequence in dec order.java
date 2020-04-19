// https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/

class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        if(nums.length==0) return new ArrayList<>();
        if(nums.length==1) return Arrays.asList(nums[0]);
        Arrays.sort(nums);
        int totalsum = 0;
        int maxsum = 0;
        List<Integer> result = new ArrayList<>();
        
        for(int i : nums) totalsum += i;
        
        for(int i=nums.length-1; maxsum<=(totalsum-maxsum); i--)
        {
            result.add(nums[i]);
            maxsum += nums[i];
        }
        
        return result;
    }
}