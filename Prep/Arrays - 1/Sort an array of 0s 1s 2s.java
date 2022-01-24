//https://leetcode.com/problems/sort-colors/

class Solution {
    public void sortColors(int[] nums) {
        if(nums==null || nums.length==0) return;
        int n = nums.length;
        int l=0, r=n-1;
        for(int i=0; i<n; i++)
        {
            if(nums[i]==0 && i>l)
            {
                int temp = nums[i];
                nums[i] = nums[l];
                nums[l] = temp;
                l++;
                i--;
            }
            else if(nums[i]==2 && i<r)
            {
                int temp = nums[i];
                nums[i] = nums[r];
                nums[r] = temp;
                r--;
                i--;
            }
        }
    }
}
