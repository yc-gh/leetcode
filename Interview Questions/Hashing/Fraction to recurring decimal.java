//https://leetcode.com/problems/fraction-to-recurring-decimal/submissions/

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0) return "0";
        StringBuilder sb = new StringBuilder();
        sb.append((numerator>0) ^ (denominator>0) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        sb.append(num/den);
        num%=den;
        if(num==0) return sb.toString();
        
        sb.append(".");
        Map<Long,Integer> map = new HashMap<>();
        
        while(num!=0)
        {
            map.put(num, sb.length());
            
            num*=10;
            sb.append(num/den);
            num%=den;
            
            Integer remainderIndex = map.get(num);
            if(remainderIndex!=null)
            {
                sb.insert(remainderIndex, "(");
                sb.append(")");
                break;
            }
        }
        
        return sb.toString();
    } 
}
