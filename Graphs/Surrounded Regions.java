//https://leetcode.com/problems/surrounded-regions/

class Solution {
    public void solve(char[][] board) {
        if(board==null || board.length==0) return;
        
        int m = board.length;
        int n = board[0].length;
        
        for(int c=0; c<n; c++) 
        {
            if(board[0][c]=='O') markConnToEdge(board,0,c);
            if(board[m-1][c]=='O') markConnToEdge(board,m-1,c);
        }
        for(int r=1; r<m-1; r++)
        {
            if(board[r][0]=='O') markConnToEdge(board,r,0);
            if(board[r][n-1]=='O') markConnToEdge(board,r,n-1);
        }
        
        for(int r=0; r<m; r++)
        {
            for(int c=0; c<n; c++)
            {
                if(board[r][c]=='*') board[r][c]='O';
                else if(board[r][c]=='O') board[r][c]='X';
            }
        }
    }
    
    private static void markConnToEdge(char[][] board, int r, int c)
    {
        if(r<0 || r>=board.length || c<0 || c>=board[0].length || board[r][c]=='X' || board[r][c]=='*') return;
        
        if(board[r][c]=='O') board[r][c]='*';
        
        markConnToEdge(board,r-1,c);
        markConnToEdge(board,r,c+1);
        markConnToEdge(board,r+1,c);
        markConnToEdge(board,r,c-1);  
    }
}
