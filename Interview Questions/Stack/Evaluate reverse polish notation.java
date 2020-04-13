// https://leetcode.com/problems/evaluate-reverse-polish-notation/

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for(String token : tokens)
        {
            if(token.equals("+"))
            {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first+second);
            }
            else if(token.equals("-"))
            {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first-second);
            }
            else if(token.equals("*"))
            {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first*second);
            }
            else if(token.equals("/"))
            {
                int second = stack.pop();
                int first = stack.pop();
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