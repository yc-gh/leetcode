//https://leetcode.com/problems/number-of-provinces/

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(isConnected, n, i, visited);
                provinces++;        
            }
        }
        
        return provinces;
    }
    
    private void dfs(int[][] isConnected, int n, int i, boolean[] visited) {
        visited[i] = true;
        for(int j=0; j<n; j++) {
            if(isConnected[i][j] == 1 && !visited[j]) {
                dfs(isConnected, n, j, visited);
            }
        }
    }
}
