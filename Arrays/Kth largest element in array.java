//https://leetcode.com/problems/kth-largest-element-in-an-array/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k-1, 0, nums.length-1);    
    }
    
    private void swap(int[] nums, int i, int j)
    {   
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private int quickSelect(int[] nums, int k, int l, int r)
    {
        if(l==r) return nums[l];
        if(l < r)
        {
            Random random_num = new Random();
            int randomIndex = l + random_num.nextInt(r-l);
            
            int p = pivot(nums, l, r, randomIndex);
            if(p == k) return nums[p];
            else if(p < k) return quickSelect(nums, k, p+1, r);
            else return quickSelect(nums, k, l, p-1);
        }
        
        return -1;
    }
    
    private int pivot(int[] nums, int l, int r, int randomIndex)
    {
        int pivot = nums[randomIndex];
        
        swap(nums, randomIndex, r);
        
        int k=l;
        
        for(int i=l; i<r; i++)
        {
            if(nums[i] > pivot)
            {
                swap(nums, i, k);
                k++;
            }
        }
        
        swap(nums, k, r);
        
        return k;
    }  
}
