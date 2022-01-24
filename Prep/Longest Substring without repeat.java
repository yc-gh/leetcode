//https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0 || s == null) return 0;
        
        int[] hash = new int[256];
        
        int i = 0, j = 0, maxLen = 0;
        
        while(j < n) {
            char curr = s.charAt(j);
            hash[curr]++;
            
            if(hash[curr] > 1) {
                while(hash[curr] != 1) {
                    hash[s.charAt(i)]--;
                    i++;
                }
            }
            
            maxLen = Integer.max(maxLen, j-i+1);
            
            j++;
        }
        
        return maxLen;
    }
}
