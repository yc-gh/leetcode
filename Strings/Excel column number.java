// https://leetcode.com/problems/excel-sheet-column-number/

class Solution {
    public int titleToNumber(String s) {
        int n = s.length()-1;
        int power = 0;
        int result = 0;
        while(n>=0)
        {
            result += ((int)Math.pow(26, power++) * (s.charAt(n)-'A' + 1));
            n--;
        }
        
        return result;
    }
}