//https://leetcode.com/problems/longest-consecutive-sequence/

class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        int max = 0;
        
        Set<Integer> set = new HashSet<>();
        
        for(int num : nums) {
            set.add(num);
        }
        
        for(int i=0; i<n; i++) {
            int num = nums[i];
            int count = 1;
            
            while(set.contains(--num)) {
                count++;
                set.remove(num);
            }
            
            num = nums[i];
            while(set.contains(++num)) {
                count++;
                set.remove(num);
            }
            
            max = Integer.max(max, count);
        }
        
        return max;
    }
}
