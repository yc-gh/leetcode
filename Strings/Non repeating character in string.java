// https://leetcode.com/problems/first-unique-character-in-a-string/

class Solution {
    public int firstUniqChar(String s) {
        int[] countarr = new int[26];
        for(int i=0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            countarr[ch-97]++;
        }
        for(int i=0; i<s.length(); i++)
        {
            if(countarr[s.charAt(i)-97]==1)
            {
                return i;
            }
        }
        
        return -1;
    }
}