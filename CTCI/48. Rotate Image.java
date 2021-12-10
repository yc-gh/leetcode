//https://leetcode.com/problems/rotate-image/

class Solution {
    public void rotate(int[][] matrix) {
        reverseRows(matrix);
        transpose(matrix);
    }
    
    private void transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i=0; i<m; i++) {
            for(int j=i; j<n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    
    private void reverseRows(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i=0, j=m-1; i<j; i++, j--) {
            int[] temp = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = temp;
        }
    }
}
