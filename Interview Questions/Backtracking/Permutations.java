//https://leetcode.com/problems/permutations/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length==0) return res;
        int n = nums.length;
        backtrack(nums, new boolean[n], res, new ArrayList<>());
        return res;
    }
    
    private static void backtrack(int[] nums, boolean[] vis, 
                                  List<List<Integer>> res, List<Integer> temp)
    {
        if(temp.size()==nums.length) 
        {
            res.add(new ArrayList(temp));
            return;
        }
        for(int i=0; i<nums.length; i++)
        {
            if(!vis[i]) 
            {
                temp.add(nums[i]);
                vis[i] = true;
                backtrack(nums, vis, res, temp);
                temp.remove(temp.size()-1);
                vis[i] = false;
            }
        }
    }
}
