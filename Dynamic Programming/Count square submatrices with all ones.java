//https://leetcode.com/problems/count-square-submatrices-with-all-ones/

class Solution {
    public int countSquares(int[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;
        
        return bottomUp(matrix);
    }
    
    private int bottomUp(int[][] matrix)
    {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(matrix[i][j]>0 && i>0 && j>0)
                {
                    matrix[i][j] = 1 + Integer.min(matrix[i-1][j-1], Integer.min(matrix[i-1][j], matrix[i][j-1]));
                }
                count += matrix[i][j];
            }
        }
        
        return count;
    }
}
