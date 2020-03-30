// https://leetcode.com/problems/game-of-life/


// Using extra space will need O(n^2)
// Use bit manipulation to store intermediate state of cells
class Solution {
    
    //     Using bit manipulation
    //     Initially board has 00 for dead and 01 for live
    //     After an update, change bits to 10 for dead->live and 11 for live->live
    //     These bits correspond to 0,1,2,3 
    //     &1 to check for current live status
    //     Right shift by 1 to get the set bit on 2nd place 
        public void gameOfLife(int[][] board) {
            if(board==null || board.length==0) return;
            int m = board.length;
            int n = board[0].length;
            
            int[] adjRow = {-1,-1,-1,0,1,1,1,0};
            int[] adjCol = {-1,0,1,1,1,0,-1,-1};
            
            for(int i=0; i<m; i++)
            {
                for(int j=0; j<n; j++)
                {
                    int curr = board[i][j];
                    int live = 0;
                    for(int k=0; k<8; k++)
                    {
                        int x = i+adjRow[k];
                        int y = j+adjCol[k];
                        if(x>=0 && x<m && y>=0 && y<n)
                        {
                            if((board[x][y]&1) == 1) live++;
                            if(live>3) break;
                        }
                    }
                    if(curr==1) //Curr is live cell
                    {
                        if(live>=2 && live<=3) board[i][j]=3; // 11 bits
                    }
                    else //Curr is dead cell
                    {
                        if(live==3) board[i][j]=2; //10 bits
                    }
                }
            }
            
            for(int i=0; i<m; i++)
            {
                for(int j=0; j<n; j++)
                {
                    board[i][j] >>= 1;
                }
            }
        }
    }