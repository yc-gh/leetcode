//https://leetcode.com/problems/find-if-path-exists-in-graph/

class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        if(start == end) return true;
        if(edges.length == 0) return false;
        
        int[] group = new int[n], size = new int[n];
        
        for(int i=0; i<n; i++) {
            group[i] = i;
            size[i] = 1;
        }
        
        for(int[] edge : edges) {
            union(group, size, edge[0], edge[1]);
        }
        
        return find(group, start, end);
    }
    
    private int root(int[] group, int i) {
        while(group[i] != i) {
            group[i] = group[group[i]];
            i = group[i];
        }
        
        return i;
    }
    
    private boolean find(int[] group, int a, int b) {
        return root(group, a) == root(group, b);
    }
    
    private void union(int[] group, int[] size, int a, int b) {
        int rootA = root(group, a), rootB = root(group, b);
        
        if(size[rootA] < size[rootB]) {
            group[rootA] = group[rootB];
            size[rootB] += size[rootA];
        }
        else {
            group[rootB] = group[rootA];
            size[rootA] += size[rootB];
        }
    }
}
