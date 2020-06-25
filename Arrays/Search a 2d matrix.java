// https://leetcode.com/problems/search-a-2d-matrix-ii/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return false;
        int col = matrix[0].length-1;
        int row = 0;
        while(col>=0 && row<matrix.length)
        {
            int curr = matrix[row][col];
            if(curr==target) return true;
            else if(target<curr) col--;
            else row++;
        }
        return false;
    }
}