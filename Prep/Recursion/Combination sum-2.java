//https://leetcode.com/problems/combination-sum-ii/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            //Avoid generating the same temp list
            //This loop just selects one number for temp
            //Skip duplicates for that one number selection
            if(i > start && candidates[i] == candidates[i-1]) continue;
            temp.add(candidates[i]);
            backtrack(candidates, target, i+1, sum + candidates[i], temp, ans);
            temp.remove(temp.size()-1);
        }
    }
}
