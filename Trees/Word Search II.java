//https://leetcode.com/problems/word-search-ii

class Solution {
    
    private class TrieNode
    {
        TrieNode[] children;
        boolean wordEndsHere, visited;
        
        TrieNode()
        {
            children = new TrieNode[26];
            wordEndsHere = false;
            visited = false;
        }
    }
    
    private TrieNode constructPrefixTree(String[] words)
    {
        TrieNode root = new TrieNode();
        
        for(String word : words)
        {
            char[] chars = word.toCharArray();
            TrieNode curr = root;
            for(int i=0; i<chars.length; i++)
            {
                int index = chars[i]-'a';
                if(curr.children[index] == null)
                {
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }
            curr.wordEndsHere = true;
        }
        
        return root;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = constructPrefixTree(words);

        List<String> res = new ArrayList<>();
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[0].length; j++)
            {
                if(root.children[board[i][j]-'a'] != null) helper(board, i, j, root, new StringBuilder(), res);
            }
        }

        return res;
    }
    
    private void helper(char[][] board, int r, int c, TrieNode root, StringBuilder sb, List<String> res)
    {
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || (board[r][c]-'a')>255) return;
        
        char ch = board[r][c];
        int index = ch - 'a';
        
        board[r][c] ^= 256;
        
        TrieNode next = root.children[index];
        
        if(next != null)
        {
            sb.append(ch);
            
            if(next.wordEndsHere && !next.visited) 
            {
                res.add(new String(sb));
                next.visited = true;
            }
            helper(board, r, c-1, next, sb, res);
            helper(board, r-1, c, next, sb, res);
            helper(board, r, c+1, next, sb, res);
            helper(board, r+1, c, next, sb, res);
            
            sb.setLength(sb.length()-1);
        }
        
        board[r][c] ^= 256;
    }
}
