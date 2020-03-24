// https://leetcode.com/problems/permutations/


//Backtracking faster
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        getPermutations(nums, 0, nums.length-1, output);
        return output;
    }
    
    static void getPermutations(int[] nums, int l, int r, List<List<Integer>> output)
    {
        if(l==r)
        {
            List<Integer> tempList = new ArrayList<>();
            for(int i : nums)
            {
                tempList.add(i);
            }
            output.add(tempList);
        }
        else
        {
            for(int i=l; i<=r; i++)
            {
                swap(nums, i, l);
                getPermutations(nums, l+1, r, output);
                swap(nums, i, l);
            }
        }
    }
    
    static void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


// Backtracking slightly slower
class Solution {
    public List<List<Integer>> permute(int[] nums) 
    {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), new boolean[nums.length], nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, boolean[] used, int[] nums)
    {
        if(tempList.size() == nums.length)
        {
            list.add(new ArrayList<>(tempList));
        } 
        else
        {
            for(int i = 0; i < nums.length; i++)
            { 
                if(used[i]) continue;
                
                tempList.add(nums[i]);
                used[i] = true;
                
                backtrack(list, tempList, used, nums);
                
                used[i] = false;
                tempList.remove(tempList.size()-1);
            }
        }
    }
}