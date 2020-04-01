// https://leetcode.com/problems/rotate-array/

class Solution {
    
    // For a array X, X^T is inversion of X
    // For matrices (AB)^T = B^T A^T
    // (X^T Y^T)^T = YX 
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        if(k==0) return;
        reverse(nums, 0, len-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, len-1);
    }
    
    void reverse(int[] nums, int start, int end)
    {
        while(start<end)
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}