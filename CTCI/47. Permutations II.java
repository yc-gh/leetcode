//https://leetcode.com/problems/permutations-ii/

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        permuteUtil(nums, new ArrayList<>(), res, new boolean[nums.length]);
        List<List<Integer>> ans = new ArrayList<>(res);
        return ans;
    }
    
    private void permuteUtil(int[] nums, List<Integer> temp, Set<List<Integer>> res, boolean[] vis) {
        if(temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
        }
        else {
            for(int i=0; i<nums.length; i++) {
                if(!vis[i]) {
                    temp.add(nums[i]);
                    vis[i] = true;
                    permuteUtil(nums, temp, res, vis);
                    vis[i] = false;
                    temp.remove(temp.size()-1);
                }
            }
        }
    }
}
