//https://leetcode.com/problems/majority-element-ii/

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        
        int count1 = 0, count2 = 0, candidate1 = 0, candidate2 = 1;
        
        for(int curr : nums) {            
            if(curr == candidate1) {
                count1++;
            }
            else if(curr == candidate2) {
                count2++;
            }
            else if(count1 == 0) {
                candidate1 = curr;
                count1 = 1;
            }
            else if(count2 == 0) {
                candidate2 = curr;
                count2 = 1;
            }
            else {
                count1--;
                count2--;
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        
        count1 = 0;
        count2 = 0;
        for(int i : nums) {
            if(i == candidate1) count1++;
            if(i == candidate2) count2++;
        }
        
        if(count1 > n/3) ans.add(candidate1);
        if(count2 > n/3) ans.add(candidate2);
        
        return ans;
    }
}
