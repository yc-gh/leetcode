//https://leetcode.com/problems/count-and-say/

class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        String prev = countAndSay(n-1);
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i<prev.length())
        {
            char ch = prev.charAt(i);
            int j = 0;
            while(i+j<prev.length() && prev.charAt(i+j)==ch) j++;
            sb.append(j);
            sb.append(ch);
            i+=j;
        }
        return sb.toString();
    }
}
