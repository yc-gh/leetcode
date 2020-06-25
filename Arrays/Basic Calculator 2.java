// https://leetcode.com/problems/basic-calculator-ii/

class Solution {
    public int calculate(String s) {
        int total = 0;
        int currNum = 0; // Read multiple digits into one number - Accumulator
        int lastNum = 0;
        char lastSign = '+';
        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c)) currNum = currNum*10 + c-'0';
            if(i==s.length()-1 || !Character.isDigit(c) && c!=' ')
            {
                switch(lastSign)
                {
                    case '+':
                        total += lastNum;
                        lastNum = currNum;
                        break;
                    case '-':
                        total += lastNum;
                        lastNum = -currNum;
                        break;
                    case '*':
                        lastNum *= currNum;
                        break;
                    case '/':
                        lastNum /= currNum;
                        break;
                }
                lastSign = c;
                currNum = 0;
            }
        }
        total += lastNum;
        return total;
    }
}