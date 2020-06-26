//https://leetcode.com/problems/word-ladder/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;
        
        Set<String> startSet = new HashSet<>(), endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        
        int len = 1;
        
        startSet.add(beginWord);
        endSet.add(endWord);
        
        while(!startSet.isEmpty())
        {
            Set<String> tempSet = new HashSet<>(); 
            
            for(String word : startSet)
            {
                char[] chars = word.toCharArray();
                for(int i=0; i<chars.length; i++)
                {
                    for(char c='a'; c<='z'; c++)
                    {
                        char old = chars[i];
                        chars[i] = c;
                        
                        String newWord = String.valueOf(chars);
                        
                        if(endSet.contains(newWord)) return len+1;
                        
                        if(!visited.contains(newWord) && wordSet.contains(newWord))
                        {
                            tempSet.add(newWord);
                            visited.add(newWord);
                        }
                        
                        chars[i] = old;
                    }
                }
            }
            
            //Choose smaller of temp or end as next start 
            if(tempSet.size() > endSet.size())
            {
                startSet = endSet;
                endSet = tempSet;
            }
            else startSet = tempSet;
            
            len++;
        }
        
        return 0;
    }
}
