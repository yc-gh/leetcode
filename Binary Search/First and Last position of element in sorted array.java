//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0) return new int[]{-1,-1};
        int l = search(nums, target, true);
        int r = search(nums, target, false);
        return l>=0 ? new int[]{l,r} : new int[]{-1,-1};
    }
    
    private static int search(int[] nums, int target, boolean searchFirst)
    {
        int l=0,r=nums.length-1,index=-1;
        while(l<=r)
        {
            int mid = l+r>>>1;
            if(nums[mid]==target)
            {
                index = mid;
                if(searchFirst) r=mid-1;
                else l=mid+1;
            }
            else if(nums[mid]>target) r=mid-1;
            else l=mid+1;
        }
        return index;
    }
}
