//https://leetcode.com/problems/4sum/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums==null || nums.length==0) return new ArrayList<>();
        
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        
        for(int i=0; i<n; i++)
        {
            for(int j=i+1; j<n; j++)
            {
                int k=j+1;
                int l=n-1;
                while(k<l)
                {
                    int sum = nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum < target) k++;
                    else if(sum > target) l--;
                    else
                    {
                        List<Integer> list = new ArrayList<>();
                        
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        
                        if(!set.contains(list)) 
                        {
                            set.add(list);
                            res.add(list);
                        }
                        k++;
                        l--;
                    }
                }
            }
        }
        
        return res;
    }
}
