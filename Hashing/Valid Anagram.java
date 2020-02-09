// https://leetcode.com/problems/valid-anagram/


// HashMap solution

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
        {
            return false;
        }
        
        Map<Character, Integer> hashmap = new HashMap<>();
        
        for(int i=0; i<s.length(); i++)
        {
            hashmap.put(s.charAt(i), hashmap.getOrDefault(s.charAt(i),0)+1);
            hashmap.put(t.charAt(i), hashmap.getOrDefault(t.charAt(i),0)-1);
        }
        
        for(char ch : hashmap.keySet())
        {
            if(hashmap.get(ch)!=0)
            {
                return false;
            }
        }
        
        return true;
    }
}


// HashTable solution

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}