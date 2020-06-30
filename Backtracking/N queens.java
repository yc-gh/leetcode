//https://leetcode.com/problems/n-queens/

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++) Arrays.fill(board[i], '.');
        
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        
        backtrack(board, n, 0, queens, res);
        return res;
    }
    
    private static boolean isSafe(int row, int col, int[] queens)
    {
        for(int currRow=0; currRow<row; currRow++)
        {
            int queenRow = currRow;
            int queenCol = queens[queenRow];
            if((queenCol == col) || (queenCol-col == queenRow-row) || (queenCol-col == row-queenRow)) return false;
        }
        return true;
    }
    
    private static void backtrack(char[][] board, int n, int row, int[] queens, List<List<String>> res)
    {
        if(row >= n) 
        {
            List<String> currConfig = new ArrayList<>();
            for(int i=0; i<n; i++)
            {
                currConfig.add(new String(board[i]));
            }
            res.add(currConfig);
            return;
        }
        
        for(int col=0; col<n; col++)
        {
            if(isSafe(row, col, queens))
            {
                board[row][col] = 'Q';
                queens[row] = col;
                backtrack(board, n, row+1, queens, res);
                queens[row] = -1;
                board[row][col] = '.';
            }
        }
    }
}
