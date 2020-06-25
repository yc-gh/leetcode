//https://leetcode.com/problems/minimum-window-substring/submissions/

class Solution {
    public String minWindow(String s, String t) {
        int minstart=0,minLength=Integer.MAX_VALUE;
        int start=0, end=0, counter=t.length();
        
        int[] map = new int[128];
        for(char c : t.toCharArray()) map[c]++;
        
        while(end<s.length())
        {
            char c1 = s.charAt(end);
            if(map[c1]>0) counter--;
            map[c1]--;
            end++;
            
            while(counter==0)
            {
                if(end-start < minLength)
                {
                    minLength = end-start;
                    minstart = start;
                }
                
                char c2 = s.charAt(start);
                map[c2]++;
                if(map[c2]>0) counter++;
                start++;
            }
        }
        
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minstart,minstart+minLength);
    }
}
