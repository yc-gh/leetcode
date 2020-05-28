//https://leetcode.com/problems/spiral-matrix-ii/

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] a = new int[n][n];
        int left=0,top=0,right=n-1,bottom=n-1;
        int k=1,sq=n*n;
        while(k<=sq)
        {
            for(int i=left; i<=right; i++)
            {
                a[top][i] = k++;
            }
            top++;
            if(k>sq) break;
            
            for(int i=top; i<=bottom; i++)
            {
                a[i][right] = k++;
            }
            right--;
            if(k>sq) break;
            
            for(int i=right; i>=left; i--)
            {
                a[bottom][i] = k++;
            }
            bottom--;
            if(k>sq) break;
            
            for(int i=bottom; i>=top; i--)
            {
                a[i][left] = k++;
            }
            left++;
        }
        return a;
    }
}
