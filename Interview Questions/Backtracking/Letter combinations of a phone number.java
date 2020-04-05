// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0) return new ArrayList<>();
        Map<Character,String> map = constructMap();
        List<String> result = new ArrayList<>();
        helper(digits, map, 0, new StringBuilder(), result);
        return result;
    }
    
    static Map<Character,String> constructMap()
    {
        Map<Character, String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        return map;
    }
    
    static void helper(String digits, Map<Character,String> map, int index, StringBuilder temp, List<String> result)
    {
        if(index >= digits.length()) 
        {
            if(temp.length()>0)
            {
                result.add(temp.toString());
            }
            return;
        }
        
        char c = digits.charAt(index);
        
        if(!map.containsKey(c)) helper(digits, map, index+1, temp, result);
        
        String mapping = map.get(c);
        
        for(int i=0; i<mapping.length(); i++)
        {
            temp.append(mapping.charAt(i));
            helper(digits, map, index+1, temp, result);
            temp.setLength(temp.length()-1);
        }
    }
}