//https://leetcode.com/problems/partition-labels/

class Solution {
    public List<Integer> partitionLabels(String S) {
        return hashingApproach(S);
        return greedyApproach(S);
    }
    
    private int greedyApproach(String S)
    {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i;
        
        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }
    
    private int hashingApproach(String S)
    {
        char[] chars = S.toCharArray();
        
        int charPresence = 0;
        int[] hash = new int[26];
        List<Integer> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for(char c : chars)
        {
            hash[c-'a']++;
        }
        
        for(char c : chars)
        {
            sb.append(c);
            hash[c-'a']--;
            if(hash[c-'a']==0)
            {
                charPresence &= ~(1<<(c-'a'));
            }
            else charPresence |= (1<<(c-'a'));
            
            if(charPresence == 0)
            {
                ans.add(sb.length());
                sb = new StringBuilder();
            }
        }
        
        return ans;
    }
}
