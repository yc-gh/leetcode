// https://leetcode.com/problems/implement-trie-prefix-tree/

class Trie {

    static class TrieNode {
        TrieNode[] arr;
        boolean wordEndsHere;

        TrieNode() {
            arr = new TrieNode[26];
            wordEndsHere = false;
        }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = null;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (root == null) {
            root = new TrieNode();
        }
        TrieNode currNode = root;
        for (int i = 0; i < word.length(); i++) {
            int currLetter = word.charAt(i) - 'a';
            if (currNode.arr[currLetter] == null) {
                currNode.arr[currLetter] = new TrieNode();
            }
            currNode = currNode.arr[currLetter];
        }
        currNode.wordEndsHere = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (root == null)
            return false;
        TrieNode currNode = root;
        for (int i = 0; i < word.length(); i++) {
            int currLetter = word.charAt(i) - 'a';
            if (currNode.arr[currLetter] == null)
                return false;
            currNode = currNode.arr[currLetter];
        }
        return currNode.wordEndsHere;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (root == null)
            return false;
        TrieNode currNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            int currLetter = prefix.charAt(i) - 'a';
            if (currNode.arr[currLetter] == null)
                return false;
            currNode = currNode.arr[currLetter];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */