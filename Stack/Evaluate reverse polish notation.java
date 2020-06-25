// https://leetcode.com/problems/evaluate-reverse-polish-notation/

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        int first,second;
        for(String token : tokens)
        {
            if(token.equals("+"))
            {
                second = stack.pop();
                first = stack.pop();
                stack.push(first+second);
            }
            else if(token.equals("-"))
            {
                second = stack.pop();
                first = stack.pop();
                stack.push(first-second);
            }
            else if(token.equals("*"))
            {
                second = stack.pop();
                first = stack.pop();
                stack.push(first*second);
            }
            else if(token.equals("/"))
            {
                second = stack.pop();
                first = stack.pop();
                stack.push(first/second);
            }
            else
            {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }
}