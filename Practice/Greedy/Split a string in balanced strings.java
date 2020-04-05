// https://leetcode.com/problems/split-a-string-in-balanced-strings/

class Solution {
    public int balancedStringSplit(String s) {
        if(s==null || s.length()==0) return 0;
        int count=0, res=0;
        for(int i=0; i<s.length(); i++)
        {
            count += s.charAt(i)=='L' ? 1 : -1;
            if(count==0) res++;
        }
        return res;
    }
}