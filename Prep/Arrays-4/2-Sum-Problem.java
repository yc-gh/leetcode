//https://leetcode.com/problems/two-sum/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++) {
            int curr = nums[i];
            if(map.containsKey(target - curr)) {
                return new int[]{i, map.get(target-curr)};
            }
            map.put(curr, i);
        }
        
        return new int[2];
    }
}
