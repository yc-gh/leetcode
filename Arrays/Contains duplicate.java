// https://leetcode.com/problems/contains-duplicate/

//Sorting 

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i++)
        {
            if(nums[i]==nums[i+1])
            {
                return true;
            }
        }
        
        return false;
    }
}

// Hashing

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> hashmap = new HashMap<>();
        for(int i : nums)
        {
            if(hashmap.containsKey(i))
            {
                return true;
            }
            else
            {
                hashmap.put(i,1);
            }
        }
        
        return false; 
    }
}


