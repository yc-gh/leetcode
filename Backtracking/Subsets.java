// https://leetcode.com/problems/subsets/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new LinkedList<>();
        backtrack(output, new LinkedList<>(), 0, nums);
        return output;
    }
    
    static void backtrack(List<List<Integer>> output, List<Integer> temp, int start, int[] nums)
    {
        output.add(new ArrayList<>(temp));
        for(int i=start; i<nums.length; i++)
        {
            temp.add(nums[i]);
            backtrack(output, temp, i+1, nums);
            temp.remove(temp.size()-1);
        }
    }
}