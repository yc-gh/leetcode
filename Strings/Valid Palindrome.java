// https://leetcode.com/problems/valid-palindrome/

//Regex
class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^\\w]+","").toLowerCase();
        if(s.length()==0) return true;
        int len = s.length();
        for(int i=0; i<=len/2; i++)
        {
            if(s.charAt(i)!=s.charAt(len-i-1)) return false;
        }
        return true;
    }
}

// Two pointer
class Solution {
    public boolean isPalindrome(String s) {
        int len = s.length();
        if(len==0) return true;
        int i=0, j=len-1;
        while(i<j)
        {
            if(s.charAt(i)==' ') i++;
            if(s.charAt(j)==' ') j--;
            char left = s.charAt(i);
            char right = s.charAt(j);
            boolean leftIsValid = Character.isLetterOrDigit(left);
            boolean rightIsValid = Character.isLetterOrDigit(right);
            if(leftIsValid && rightIsValid)
            {
                left = Character.toLowerCase(left);
                right = Character.toLowerCase(right);
                if(left != right) return false;
                i++;
                j--;
            }
            else
            {
                if(!leftIsValid) i++;
                if(!rightIsValid) j--;
            }
        }
        return true;
    }
}