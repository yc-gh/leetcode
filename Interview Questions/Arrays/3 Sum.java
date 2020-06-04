//https://leetcode.com/problems/3sum/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums==null || nums.length==0) return new ArrayList<>();
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<n-2; i++)
        {
            if(nums[i]>0) break;
            if(i>0 && nums[i]==nums[i-1]) continue;
            
            int j=i+1, k=n-1;
            
            while(j<k)
            {
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0)
                {
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while(j<k && nums[j]==nums[j+1]) j++;
                    while(j<k && nums[k]==nums[k-1]) k--;
                    j++;
                    k--;
                }
                else if(sum>0)
                {
                   while(j<k && nums[k]==nums[k-1]) k--;
                    k--;
                }
                else
                {
                   while(j<k && nums[j]==nums[j+1]) j++;
                    j++;
                }
            }
        }
        return res;
        
//         Set<List<Integer>> res  = new HashSet<>();
//         if(nums.length==0) return new ArrayList<>(res);
//         Arrays.sort(nums);
//         for(int i=0; i<nums.length-2;i++){
//             int j =i+1;
//            int  k = nums.length-1;
//             while(j<k){
//                 int sum = nums[i]+nums[j]+nums[k];
//                 if(sum==0)res.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
//                 else if ( sum >0) k--;
//                 else if (sum<0) j++;
//             }

//         }
//         return new ArrayList<>(res);
    }
}
