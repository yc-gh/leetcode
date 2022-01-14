//https://leetcode.com/problems/search-in-rotated-sorted-array/

class Solution {
    public int search(int[] nums, int target) {
        
        int l = 0, r = nums.length-1;
        
        //Search among the (potentially) two sorted sections
        
        while(l <= r) {
            int mid = (l+r)>>>1;
            if(nums[mid] == target) return mid;
            
            if(nums[mid] >= nums[l]) {
                if(target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                }
                else {
                    l = mid + 1;
                }
            }
            
            if(nums[mid] <= nums[r]) {
                if(target <= nums[r] && target > nums[mid]) {
                    l = mid + 1;
                }
                else {
                    r = mid - 1;
                }
            }
        }
        
        return -1;
    }
}
