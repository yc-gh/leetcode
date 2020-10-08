//https://leetcode.com/problems/most-common-word/

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        Set<String> bannedWords = new HashSet<>();
        for(String word : banned) bannedWords.add(word);
        
        Map<String, Integer> wordCount = new HashMap<>();
        
        StringBuilder wordBuffer  = new StringBuilder();
        
        char[] chars = paragraph.toCharArray();
        
        int maxCount = 0;
        String commonWord = null;
        
        for(int i=0; i<chars.length; i++)
        {
            char currChar = chars[i];
            
            if(Character.isLetter(currChar))
            {
                wordBuffer.append(Character.toLowerCase(currChar));
                
                if(i != chars.length-1) continue;
            }
            
            if(wordBuffer.length()>0)
            {
                String word = wordBuffer.toString();
                
                if(!bannedWords.contains(word))
                {
                    int count = wordCount.getOrDefault(word, 0) + 1;
                    
                    wordCount.put(word, count);
                    
                    if(count > maxCount)
                    {
                        maxCount = count;
                        commonWord = word;
                    }
                }
                
                wordBuffer = new StringBuilder();
            }
        }
        
        return commonWord;
    }
}
