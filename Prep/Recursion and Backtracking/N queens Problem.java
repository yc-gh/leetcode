//https://leetcode.com/problems/n-queens/

//Time complexity O(n!)
//Space complexity O(n)

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] row : board) {
            Arrays.fill(row, '.');
        }
        
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        
        backtrack(board, n, 0, queens, ans);
        return ans;
    }
    
    private void backtrack(char[][] board, int n, int r,
                           int[] queens, List<List<String>> ans) {
        if(r >= n) {
            ans.add(convertBoardToList(board));
            return;            
        }
        
        for(int c=0; c<n; c++) {
            if(isSafe(r, c, queens)) {
                board[r][c] = 'Q';
                queens[r] = c;
                backtrack(board, n, r+1, queens, ans);
                queens[r] = -1;
                board[r][c] = '.';
            }
        }
    }
    
    private List<String> convertBoardToList(char[][] board) {
        List<String> res = new ArrayList<>();
        for(char[] row : board) {
            res.add(new String(row));
        }
        return res;
    }
    
    private boolean isSafe(int r, int c, int[] queens) {
        for(int i=0; i<r; i++) {
            int x = i;
            int y = queens[i];
            
            if(x == r || y == c) return false;
            if((c - y == r - x) || (c - y == x - r)) return false;
        }
        
        return true;
    }
}
