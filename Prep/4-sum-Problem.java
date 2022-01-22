//https://leetcode.com/problems/4sum/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        
        Arrays.sort(nums);
        
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int k = j + 1;
                int l = n - 1;
                
                while(k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    
                    if(sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        
                        if(!set.contains(temp)) {
                            ans.add(temp);
                            set.add(temp);
                        }
                        
                        k++;
                        l--;
                    }
                    else if(sum > target) l--;
                    else k++;
                }
            }
        }
        
        return ans;
    }
}
