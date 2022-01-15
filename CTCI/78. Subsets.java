//https://leetcode.com/problems/subsets/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        buildSubsets(nums, 0, new ArrayList<>(), res);
        return res;
    }
    
    private void buildSubsets(int[] nums, int currIndex, 
            List<Integer> temp, List<List<Integer>> res)
    {
        res.add(new ArrayList<>(temp));
        if(currIndex >= nums.length) {
            return;
        }
        
        for(int i=currIndex; i<nums.length; i++) {
            temp.add(nums[i]);
            buildSubsets(nums, i+1, temp, res);
            temp.remove(temp.size()-1);
        }
    }
}
