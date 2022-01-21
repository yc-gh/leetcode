//https://leetcode.com/problems/search-a-2d-matrix/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        
        for(int i=0; i<m; i++) {
            if(target >= matrix[i][0] && target <= matrix[i][n-1]) {
                return binarySearch(matrix[i], target) >= 0;
            }
        }
        
        return false;
    }
    
    private int binarySearch(int[] arr, int target) {
        int i=0, j=arr.length-1;
        
        while(i <= j) {
            // int mid = (i+j)>>>1;
            int mid = i + (j-i)/2;
            if(target == arr[mid]) return mid;
            else if(target < arr[mid]) j = mid-1;
            else i = mid + 1;
        }
        
        return -1;
    }
}
