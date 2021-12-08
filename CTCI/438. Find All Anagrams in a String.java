//https://leetcode.com/problems/find-all-anagrams-in-a-string/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int len1 = s.length(), len2 = p.length();
        List<Integer> res = new ArrayList<>();
        if(len2 > len1) return res;
        
        int[] count = new int[26];
        for(char c : p.toCharArray()) {
            count[c - 'a']++;
        }
        
        int i=0, j=0, charsToBeFound = len2;
        
        while(j<len2) {
            if(count[s.charAt(j++) - 'a']-- > 0) charsToBeFound--;
        }
        
        if(charsToBeFound == 0) res.add(0);
        
        while(j<len1) {
            if(count[s.charAt(i++) - 'a']++ >= 0) charsToBeFound++;
            if(count[s.charAt(j++) - 'a']-- > 0) charsToBeFound--;
            if(charsToBeFound == 0) res.add(j-len2);
        }
        
        return res;
    }
}
