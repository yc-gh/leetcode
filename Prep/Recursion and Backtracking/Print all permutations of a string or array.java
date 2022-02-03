//https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1/

class Solution {
    public List<String> find_permutation(String S) {
        List<String> ans = new ArrayList<>();
        
        int len = S.length();
        backtrack(S, len, new boolean[len], new StringBuilder(), ans);
        Collections.sort(ans);
        return ans;
    }
    
    private void backtrack(String str, int len, boolean[] vis, StringBuilder sb, List<String> ans) {
        if(sb.length() == len) {
            ans.add(new String(sb));
            return;
        }
        
        for(int i=0; i<len; i++) {
            if(!vis[i]) {
                sb.append(str.charAt(i));
                vis[i] = true;
                backtrack(str, len, vis, sb, ans);
                sb.setLength(sb.length()-1);
                vis[i] = false;
            }
        }
    }
}
