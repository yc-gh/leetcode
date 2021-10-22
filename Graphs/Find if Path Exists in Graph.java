//https://leetcode.com/problems/find-if-path-exists-in-graph/

class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        if(start == end) return true;
        if(edges.length == 0) return false;
        
        int[] parent = new int[n], size = new int[n];
        
        for(int i=0; i<n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        
        for(int[] edge : edges) {
            union(parent, size, edge[0], edge[1]);
        }
        
        return find(parent, start, end);
    }
    
    private int root(int[] parent, int i) {
        while(parent[i] != i) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        
        return i;
    }
    
    private boolean find(int[] parent, int a, int b) {
        return root(parent, a) == root(parent, b);
    }
    
    private void union(int[] parent, int[] size, int a, int b) {
        int rootA = root(parent, a), rootB = root(parent, b);
        
        if(size[rootA] < size[rootB]) {
            parent[rootA] = parent[rootB];
            size[rootB] += size[rootA];
        }
        else {
            parent[rootB] = parent[rootA];
            size[rootA] += size[rootB];
        }
    }
}
