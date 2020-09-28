//https://leetcode.com/problems/flood-fill/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor) return image;
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private void dfs(int[][] image, int r, int c, int currColor, int newColor)
    {
        if(r<0 || r>=image.length || c<0 || c>=image[0].length || image[r][c]!=currColor) return;
        
        image[r][c] = newColor;
        
        dfs(image, r, c-1, currColor, newColor);
        dfs(image, r-1, c, currColor, newColor);
        dfs(image, r, c+1, currColor, newColor);
        dfs(image, r+1, c, currColor, newColor);
    }
}
