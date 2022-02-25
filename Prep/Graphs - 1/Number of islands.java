//https://leetcode.com/problems/number-of-islands/

class Solution {
    int[] parent;
    int[] size;
    
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        parent = new int[m*n];
        size = new int[m*n];
        Arrays.fill(parent, -1);
        Arrays.fill(size, 1);
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1') {
                    parent[i*n+j] = i*n+j;
                    if(i>0 && grid[i-1][j] == '1') union(i*n+j, (i-1)*n+j);
                    if(j>0 && grid[i][j-1] == '1') union(i*n+j, i*n+(j-1));
                }
            }
        }
        
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<parent.length; i++) {
            if(parent[i] != -1) {
                set.add(find(i));
            }
        }
        
        return set.size();
    }
    
    private int find(int u) {
        if(u == parent[u]) return u;

        return parent[u] = find(parent[u]);
    }
        
    private void union(int u, int v) {
        u = find(u);
        v = find(v);

        if(u == v) return;

        if(size[u] < size[v]) {
            parent[u] = v;
            size[v] += size[u];
        }
        else {
            parent[v] = u;
            size[u] += size[v];
        }
    }
}
