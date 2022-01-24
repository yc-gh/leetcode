//https://leetcode.com/problems/set-matrix-zeroes/

class Solution {
    public void setZeroes(int[][] matrix) {
        //Instead of finding zeroes and filling zeroes in row and column
        //Store information about which cells should be zeroes - as zeroes in first row and column
        //Then set zeroes in individual cells
        
        int m = matrix.length, n = matrix[0].length;
        boolean firstRowZero = false, firstColZero = false;
        
        for(int i=0; i<m; i++) {
            if(matrix[i][0] == 0) firstColZero = true;
        }
        
        for(int j=0; j<n; j++) {
            if(matrix[0][j] == 0) firstRowZero = true;
        }
        
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(firstColZero) {
            for(int i=0; i<m; i++) {
                matrix[i][0] = 0;
            }
        }
        
        if(firstRowZero) {
            for(int j=0; j<n; j++) {
                matrix[0][j] = 0;
            }
        }
        
    }
}
