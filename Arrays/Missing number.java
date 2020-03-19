// https://leetcode.com/problems/missing-number/

//XOR of given numbers with 0 to n (n+1) gives missing number

class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0;
        int i = 0;
        for(i=0; i<nums.length; i++)
        {
            xor ^= i ^ nums[i];
        }
        
        return xor^i;
    }
}


//Binary search in sorted array

class Solution {
    public int missingNumber(int[] nums) { //binary search
        Arrays.sort(nums);
        int left = 0, right = nums.length;
        while(left<right){
            mid = (left + right)/2;
            if(nums[mid]>mid) right = mid;
            else left = mid+1;
        }
        return left;
    }
}