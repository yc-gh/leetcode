// https://leetcode.com/problems/valid-parentheses/

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            switch (curr) {
                case '(':
                    stack.push('(');
                    break;

                case '{':
                    stack.push('{');
                    break;

                case '[':
                    stack.push('[');
                    break;

                case ')':
                    if (!stack.isEmpty()) {
                        char top = stack.pop();
                        if (top != '(')
                            return false;
                    } else
                        return false;
                    break;

                case '}':
                    if (!stack.isEmpty()) {
                        char top = stack.pop();
                        if (top != '{')
                            return false;
                    } else
                        return false;
                    break;

                case ']':
                    if (!stack.isEmpty()) {
                        char top = stack.pop();
                        if (top != '[')
                            return false;
                    } else
                        return false;
                    break;
            }
        }

        return stack.isEmpty();
    }
}