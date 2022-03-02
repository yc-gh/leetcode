//https://leetcode.com/problems/reverse-words-in-a-string/

class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split("\\s+");
        for(int i=0, j=words.length-1; i<j; i++, j--) {
            String temp = words[i];
            words[i] = words[j];
            words[j] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for(String word : words) {
            sb.append(word);
            sb.append(" ");
        }
        sb.setLength(sb.length()-1);
        return new String(sb);
    }
}
