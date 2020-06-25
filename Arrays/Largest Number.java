//https://leetcode.com/problems/largest-number/

class Solution {
    public String largestNumber(int[] nums) {
        if(nums==null || nums.length==0) return "0";
        int n = nums.length;
        String[] stringnums = new String[n];
        
        for(int i=0; i<n; i++)
        {
            stringnums[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(stringnums, (s1,s2)->(s2+s1).compareTo(s1+s2));
        
        if(stringnums[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        for(String s : stringnums) sb.append(s);
        
        return sb.toString();
    }
} 
