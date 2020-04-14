// https://leetcode.com/problems/search-in-rotated-sorted-array/

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low=0, high=n-1;
        //Find lowest element(first)
        while(low<high)
        {
            int mid = low+(high-low)/2;
            if(nums[mid]>nums[high]) low=mid+1;
            else high=mid;
        }
        
        int rot=low; //First element's index indicates the rotation
        
        low=0;
        high=n-1;
        
        //Binary search in original array 
        //But consider mid as element from rotated(given) array
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            int rotatedMid = (mid+rot)%n;
            if(nums[rotatedMid]==target) return rotatedMid;
            else if(nums[rotatedMid]>target) high=mid-1;
            else low=mid+1;
        }
        
        return -1;
    }
}