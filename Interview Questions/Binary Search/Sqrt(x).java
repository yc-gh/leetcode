//https://leetcode.com/problems/sqrtx/

class Solution {
    public int mySqrt(int x) {
        if(x==0) return 0;
        int l=1,r=x;
        while(l<r)
        {
            int mid = l+r+1>>>1;
            if(mid>x/mid) r=mid-1;
            else l=mid;
        }
        return l;
    }
}
