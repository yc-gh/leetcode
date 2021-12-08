//https://leetcode.com/problems/valid-anagram/

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        char[] count1 = new char[26];
        
        for(char c : s.toCharArray()) 
        {
            count1[c - 97]++;
        }
        
        for(char c : t.toCharArray()) 
        {
            count1[c - 97]--;
        }
        
        for(int i : count1)
        {
            if(i != 0) return false;
        }
        
        return true;
    }
}
