// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0) return new int[]{-1,-1};
        if(nums.length==1) 
        {
            if(nums[0]==target) return new int[]{0,0};
            return new int[]{-1,-1};
        }
        int left=0, right=nums.length-1;
        int first=-1, last=-1;
        int bsIndex=-1;
        int mid=-1;
        while(left <= right)
        {
            mid = left+(right-left)/2;
            if(nums[mid]==target)
            {
                bsIndex=mid;
                break;
            }
            else if(nums[mid]>target) right=mid-1;
            else left=mid+1;
        }
        
        if(bsIndex==-1) return new int[]{-1,-1};
        
        first = findFirst(nums, target, 0, mid);
        last = findLast(nums, target, mid, nums.length-1);
        
        return new int[]{first, last};
    }
    
    static int findFirst(int[] nums, int target, int left, int right)
    {
        while(left<=right)
        {
            int mid = left+(right-left)/2;
            if(nums[mid]==target)
            {
                if(mid-1>=0 && nums[mid-1]==target)
                {
                    right = mid-1;
                }
                else  return mid;
            }
            else if(nums[mid]>target) right=mid-1;
            else left=mid+1;
        }
        return left;
    }
    
    static int findLast(int[] nums, int target, int left, int right)
    {
        while(left<=right)
        {
            int mid = left+(right-left)/2;
            if(nums[mid]==target)
            {
                if(mid+1<nums.length && nums[mid+1]==target)
                {
                    left = mid+1;
                }
                else  return mid;
            }
            else if(nums[mid]>target) right=mid-1;
            else left=mid+1;
        }
        return left;
    }
}