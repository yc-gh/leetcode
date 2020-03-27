// https://leetcode.com/problems/implement-strstr/

// KMP Approach TODO

// Brute force
class Solution {
    public int strStr(String haystack, String needle) {
        int n = needle.length();
        int h = haystack.length();
        if(n==0) return 0;
        for(int i=0; i<=h-n; i++)
        {
            if(haystack.charAt(i)==needle.charAt(0))
            {
                int j;
                for(j=1; j<needle.length(); j++)
                {
                    if(haystack.charAt(i+j)!=needle.charAt(j))
                        break;
                }
                if(j==needle.length())
                {
                    return i;
                }
            }
        }
        return -1;
    }
}