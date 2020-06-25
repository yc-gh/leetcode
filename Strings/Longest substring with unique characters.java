// https://leetcode.com/problems/longest-substring-without-repeating-characters/

// Hashing - faster
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        int[] hash = new int[256];
        int max = 0;
        for(int r=0, l=0; r<s.length(); r++)
        {
            int ch = s.charAt(r);
            if(hash[ch]>0)
            {
                l = Integer.max(l, hash[ch]);
            }
            hash[ch] = r+1;
            max = Integer.max(max, r-l+1);
        }
        return max;
    }
}

// HashMap - slower
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int max = 0;
        for(int r=0, l=0; r<s.length(); r++)
        {
            char ch = s.charAt(r);
            if(map.containsKey(ch))
            {
                //Update left pointer 
                //Avoid moving left pointer back 
                l = Integer.max(l, map.get(ch)+1);
            }
            map.put(ch, r); // Update hash vals for each character
            max = Integer.max(max, r-l+1); //Update length in current substring
        }
        return max;
    }
}