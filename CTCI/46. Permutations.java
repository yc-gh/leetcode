//https://leetcode.com/problems/permutations/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permuteUtil(nums, new ArrayList<>(), res, new boolean[nums.length]);
        return res;
    }
    
    private void permuteUtil(int[] nums, List<Integer> temp, List<List<Integer>> res, boolean[] vis) {
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
