// https://leetcode.com/problems/string-to-integer-atoi/submissions/

class Solution {
    public int myAtoi(String str) {
        int n = str.length();
        if(n==0) return 0;
        int sign=1, num=0, i=0, IntMax=Integer.MAX_VALUE, IntMin=Integer.MIN_VALUE;
        while(i<n && str.charAt(i)==' ') i++;
        if(i<n && (str.charAt(i)=='+' || str.charAt(i)=='-'))
            sign = str.charAt(i++)=='+' ? 1 : -1;
        while(i<n && str.charAt(i)>='0' && str.charAt(i)<='9')
        {
            if(num>IntMax/10 || (num==IntMax/10 && (str.charAt(i)-'0'>IntMax%10)))
            {
                return sign==1 ? IntMax : IntMin;
            }
            num = num * 10 + (str.charAt(i++) -'0');
        }
        return num * sign;
    }
}