//https://leetcode.com/problems/implement-trie-prefix-tree/

class Trie {
    
    class TrieNode {
        TrieNode[] arr = new TrieNode[26];
        boolean wordEndsHere = false;
    }
    
    TrieNode root = null;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        
        for(char c : word.toCharArray()) {
            if(curr.arr[c - 'a'] == null) {
                curr.arr[c - 'a'] = new TrieNode();
            }
            curr = curr.arr[c - 'a'];
        }
        
        curr.wordEndsHere = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        
        for(char c : word.toCharArray()) {
            if(curr.arr[c - 'a'] == null) {
                return false;
            }
            curr = curr.arr[c - 'a'];
        }
        
        return curr.wordEndsHere;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        
        for(char c : prefix.toCharArray()) {
            if(curr.arr[c - 'a'] == null) {
                return false;
            }
            curr = curr.arr[c - 'a'];
        }
        
        return true;
    }
}
