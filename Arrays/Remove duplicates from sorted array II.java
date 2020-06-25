//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int k=0;
        for(int i=1; i<nums.length; i++)
        {
            if(nums[i]==nums[k])
            {
                if(k==0 || nums[k]!=nums[k-1])
                {
                    k++;
                    int temp = nums[i];
                    nums[i] = nums[k];
                    nums[k] = temp;
                }
            }
            else
            {
                k++;
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
            }
        }
        return k+1;
    }
}
