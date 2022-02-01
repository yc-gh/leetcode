//https://leetcode.com/problems/combination-sum/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return ans;
        
        Arrays.sort(candidates);
        
        backtrack(candidates, target, 0, 0, new ArrayList<>(), ans);
        
        return ans;
    }
    
    private void backtrack(int[] candidates, int target, int start, int sum, List<Integer> temp,
                            List<List<Integer>> ans) {
        
        if(sum == target) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        else if(sum > target) {
            return;
        }
        
        for(int i=start; i<candidates.length; i++) {
            temp.add(candidates[i]);
            backtrack(candidates, target, i, sum + candidates[i], temp, ans);
            temp.remove(temp.size()-1);
        }
    }
}
