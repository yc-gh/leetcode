//Modification of
//https://leetcode.com/problems/subsets/

class Solution {
    public List<Integer> subsets(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        buildSubsets(nums, 0, new ArrayList<>(), res);
        Collections.sort(res);
        return res;
    }
    
    private void buildSubsets(int[] nums, int currIndex, 
            List<Integer> temp, List<Integer> res)
    {
        int sum = 0;
        for(int i : temp) sum += i;
        res.add(sum);
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
