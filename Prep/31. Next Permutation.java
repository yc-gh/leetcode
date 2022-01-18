//https://leetcode.com/problems/next-permutation/

class Solution {
    
    //Starting from end of array
    //Find pivot point where descending sequence ends
    //Find smallest greater number to right of pivot
    //Swap with pivot
    //Reverse numbers to right of pivot
    
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        
        int i = n-2;
        while(i >= 0 && nums[i]>=nums[i+1]) {
            i--;
        }
        
        if(i < 0) {
            Arrays.sort(nums);
            return;
        }
        
        int j = i+1;
        while(j < n && nums[j] > nums[i]) {
            j++;
        }
        
        swap(nums, i, j-1);
        
        reverse(nums, i+1, n-1);
        return;
    }
    
    private void reverse(int[] nums, int i, int j) {
        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
