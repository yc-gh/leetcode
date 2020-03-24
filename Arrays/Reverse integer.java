// https://leetcode.com/problems/reverse-integer/

class Solution {
    public int reverse(int x) {
        int prevRev = 0, rev = 0;
        while(x!=0)
        {
            rev = rev*10 + x%10;
            //Check if new integer has overflowed
            //Compare it to previous reversed integer
            if((rev - x%10)/10 != prevRev)
            {
                return 0;
            }
            prevRev = rev;
            x/=10;
        }
        
        return rev;
    }
}