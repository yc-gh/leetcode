//https://leetcode.com/problems/search-insert-position/

class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums==null || nums.length==0) return 0;
        int l=0,r=nums.length;
        while(l<r)
        {
            int mid = l+r>>>1;
            if(nums[mid]<target) l=mid+1;
            else r=mid;
        }
        return l;
    }
}
