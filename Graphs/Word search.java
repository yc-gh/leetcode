// https://leetcode.com/problems/word-search/

class Solution {
    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, r, c, word, 0))
                        return true;
                }
            }
        }

        return false;
    }

    static boolean dfs(char[][] board, int i, int j, int r, int c, String word, int index) {
        if (i < 0 || i >= r || j < 0 || j >= c)
            return false;
        if (board[i][j] != word.charAt(index))
            return false;
        if (index + 1 >= word.length())
            return true;

        //Instead of using visited array
        //Set current character to an out of range character (> 0-255)
        //Java uses 2 bytes for chars 
        board[i][j] ^= 256;

        boolean found = dfs(board, i, j - 1, r, c, word, index + 1) || dfs(board, i - 1, j, r, c, word, index + 1)
                || dfs(board, i, j + 1, r, c, word, index + 1) || dfs(board, i + 1, j, r, c, word, index + 1);

        if (found)
            return true;

        board[i][j] ^= 256;

        return false;
    }
}