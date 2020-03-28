// https://leetcode.com/problems/spiral-matrix/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix==null || matrix.length==0) return new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int n = matrix.length * matrix[0].length;
        int count=0;
        int left=0, right=matrix[0].length-1, up=0, down=matrix.length-1;
        while(count<n)
        {
            for(int j=left; j<=right; j++)
            {
                output.add(matrix[up][j]);
                count++;
            }
            up++;
            if(count>=n) break;
            for(int i=up; i<=down; i++)
            {
                output.add(matrix[i][right]);
                count++;
            }
            right--;
            if(count>=n) break;
            for(int j=right; j>=left; j--)
            {
                output.add(matrix[down][j]);
                count++;
            }
            down--;
            if(count>=n) break;
            for(int i=down; i>=up; i--)
            {
                output.add(matrix[i][left]);
                count++;
            }
            left++;
        }
        return output;
    }
}