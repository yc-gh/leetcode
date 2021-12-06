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

//Disjoint Set

class Solution {
    int[] parent, size;
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        
        initDisjointSets(n);
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(isConnected[i][j] == 1) {
                    combine(i, j);
                }
            }
        }
        
        int provinces = 0;
        
        for(int i=0; i<n; i++) {
            if(parent[i] == i) provinces++;
        }
        
        return provinces;
    }
    
    private void initDisjointSets(int n) {
        parent = new int[n];
        size = new int[n];
        
        for(int i=0; i<n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    private int find(int a) {
        if(a == parent[a]) return a;
        
        return parent[a] = find(parent[a]);
    }
    
    private void combine(int a, int b) {
        a = find(a);
        b = find(b);
        
        if(a == b) return;
        else {
            if(size[a] > size[b]) {
                parent[b] = a;
                size[a] += size[b];
            }
            else {
                parent[a] = b;
                size[b] += size[a];
            }
        }
    }
}
