//https://leetcode.com/problems/word-break/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        
        return backtrack(s, 0, wordSet, new Boolean[s.length()+1]);
    }
    
    private boolean backtrack(String s, int start, Set<String> wordSet, Boolean[] memo) {
        
        if(memo[start] != null) return memo[start];
        
        if(start == s.length()) {
            return memo[start] = true;
        }
        
        for(int i=start; i<s.length(); i++) {
            String substring = s.substring(start, i+1);
            if(wordSet.contains(substring)) {
                if(backtrack(s, i+1, wordSet, memo)) {
                    return memo[start] = true;
                }
            }
        }
        
        return memo[start] = false;
    }
}
