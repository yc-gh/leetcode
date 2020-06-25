//https://leetcode.com/problems/powx-n/

class Solution {
    public double myPow(double x, int n) {
        double res=1;
        long nAbs = Math.abs((long)n);
        while(nAbs>0)
        {
            if((nAbs&1)==1) res *= x;
            nAbs>>=1;
            x=x*x;
        }
        return n>=0 ? res : 1/res;
    }
}
