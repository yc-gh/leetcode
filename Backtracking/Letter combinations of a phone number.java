// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits==null || digits.length()==0) return res;
        String[] mapping = new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs",
                                "tuv","wxyz"
        };
        backtrack(digits.toCharArray(), mapping, 0, res, new StringBuilder());
        return res;
    }
    
    private static void backtrack(char[] digits, String[] mapping, int curr, List<String> res, StringBuilder sb)
    {
        if(curr==digits.length)
        {
            res.add(sb.toString());
            return;
        }
        for(char c : mapping[digits[curr]-'0'].toCharArray())
        {
            sb.append(c);
            backtrack(digits,mapping,curr+1,res,sb);
            sb.setLength(sb.length()-1);
        }
    }
}
