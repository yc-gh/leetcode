//https://leetcode.com/problems/palindrome-partitioning/

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        
        if(s == null || s.length() == 0) return ans;
        
        backtrack(s, 0, new ArrayList<>(), ans);
        return ans;
    }
    
    private void backtrack(String s, int start, List<String> temp, 
                           List<List<String>> ans) {
        
        if(start == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        else {
            for(int i=start; i<s.length(); i++) {
                if(isPalindrome(s, start, i)) {
                    temp.add(s.substring(start, i+1));
                    backtrack(s, i+1, temp, ans);
                    temp.remove(temp.size()-1);
                }
            }
        }
    }
    
    private boolean isPalindrome(String s, int low, int high) {
        while(low < high) {
            if(s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }
}
