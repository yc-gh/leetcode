//https://leetcode.com/problems/flood-fill/

class Solution {
    int[] adjX = new int[]{-1, 0, 1, 0};
    int[] adjY = new int[]{0, -1, 0, 1};
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        bfs(image, sr, sc, image[sr][sc], newColor, new boolean[image.length][image[0].length]);
        return image;
    }
    
    private void bfs(int[][] image, int r, int c, int currColor, int newColor, boolean[][] vis) {
        if(!isValid(image, r, c, currColor, vis)) return;
        
        vis[r][c] = true;
        image[r][c] = newColor;
        
        for(int i=0; i<4; i++) {
            bfs(image, r+adjX[i], c+adjY[i], currColor, newColor, vis);
        }
    }
    
    private boolean isValid(int[][] image, int r, int c, int currColor, boolean[][] vis) {
        return (r >= 0 && r < image.length) && 
                (c >= 0 && c < image[0].length) &&
                (image[r][c] == currColor) &&
                !vis[r][c];
    }
}
