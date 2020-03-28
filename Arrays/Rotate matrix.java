// https://leetcode.com/problems/rotate-image/

class Solution {
    //     For anticlockwise reverse left to right and transpose
    //     or transpose and reverse up to down     
    //     For clockwise reverse up to down and transpose
        public void rotate(int[][] matrix) {
            if(matrix==null || matrix.length==0) return;
            int n = matrix.length;
            reverseUpDown(matrix, n);
            transpose(matrix, n);
        }
        
        static void reverseUpDown(int[][] matrix, int n)
        {
            for(int i=0,k=n-1; i<k; i++,k--)
            {
                int[] temp = matrix[i];
                matrix[i] = matrix[k];
                matrix[k] = temp;
            }
        }
        
        static void transpose(int[][] matrix, int n)
        {
            for(int i=0; i<n; i++)
            {
                for(int j=i; j<n; j++)
                {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }   
            }
        }
    }