//https://leetcode.com/problems/permutation-in-string/

class Solution {
    public boolean checkInclusion(String s1, String s2) {        
        int len1 = s1.length(), len2 = s2.length();
        if(len1 > len2) return false;
        
        int[] count1 = new int[26];
        for(char c : s1.toCharArray()) {
            count1[c - 'a']++;
        }
        
        for(int i=0; i<len2; i++) {
            count1[s2.charAt(i) - 'a']--;
            if(i >= len1) count1[s2.charAt(i-len1) - 'a']++;
            if(allCharsFound(count1)) return true;
        }
        
        return false;
    }
    
    private boolean allCharsFound(int[] count) {
        for(int i=0; i<26; i++) {
            if(count[i] != 0) return false;
        }
        
        return true;
    }
}

//Optimized

class Solution {
    public boolean checkInclusion(String s1, String s2) {        
        int len1 = s1.length(), len2 = s2.length();
        if(len1 > len2) return false;
        
        int[] count = new int[26];
        for(char c : s1.toCharArray()) {
            count[c - 'a']++;
        }
        
        int i=0, j=0, charsToBeFound = len1;
        
        while(j<len1) {
            if(count[s2.charAt(j++) - 'a']-- > 0) charsToBeFound--;
        }
        
        while(j<len2 && charsToBeFound != 0) {
            if(count[s2.charAt(i++) - 'a']++ >= 0) charsToBeFound++;
            if(count[s2.charAt(j++) - 'a']-- > 0) charsToBeFound--;
        }
        
        return charsToBeFound == 0;
    }
}
