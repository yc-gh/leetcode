//https://leetcode.com/problems/first-unique-character-in-a-string/

class Solution {
    public int firstUniqChar(String s) {
        if(s==null || s.length()==0) return -1;
        
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        
        for(char ch : chars)
        {
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        
        for(int i=0; i<chars.length; i++)
        {
            if(map.get(chars[i])==1) return i;
        }
        
        return -1;
    }
}

//Alternative approach 

class Solution {
    public int firstUniqChar(String s) {
        if(s==null || s.length()==0) return -1;
        
        Map<Character, Integer> map = new LinkedHashMap<>();
        Set<Character> set = new HashSet<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) 
            {
                if (map.get(s.charAt(i)) != null) 
                {
                    map.remove(s.charAt(i));
                }
            } 
            else 
            {
                map.put(s.charAt(i), i);
                set.add(s.charAt(i));
            }
        }
        return map.isEmpty()https://leetcode.com/problems/first-unique-character-in-a-string/ ? -1 : map.values().iterator().next();
    }
}
