// https://leetcode.com/problems/generate-parentheses/

class Solution {
    public List<String> generateParenthesis(int n) {
        if(n==0) return new ArrayList<String>();
        List<String> output = new LinkedList<>();
        backtrack(output, new StringBuilder(), 0, 0, n);
        return output;
    }
    
    static void backtrack(List<String> output, StringBuilder temp, int open, int close, int total)
    {
        if(temp.length() == total*2)
        {
            output.add(temp.toString());
            return;
        }
        
        if(open < total)
        {
            temp.append("(");
            backtrack(output, temp, open+1, close, total);
            temp.deleteCharAt(temp.length()-1);
        }
        if(close < open)
        {
            temp.append(")");
            backtrack(output, temp, open, close+1, total);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}