//https://leetcode.com/problems/max-area-of-island/

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        ModifiedDSU dsu = new ModifiedDSU(grid, m, n);
        
        return dsu.maxSize;
    }
}

class ModifiedDSU {
    int[] parent, size;
    int maxSize = 0;
    
    ModifiedDSU(int[][] grid, int m, int n) {
        parent = new int[m*n];
        size = new int[m*n];
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int index = (i * n) + j;
                if(grid[i][j] == 1) {
                    if(parent[index] == 0) {
                        parent[index] = index;
                        size[index] = 1;
                        if(maxSize == 0) maxSize = 1;
                    }
                    
                    if((j-1 >= 0) && grid[i][j-1]==1) {
                        int nextIndex = i*n+(j-1);
                        if(size[nextIndex] == 0) {
                            parent[nextIndex] = nextIndex;
                            size[nextIndex] = 1;
                        }
                        union(index, nextIndex);
                    } 
                    if((i-1 >= 0) && grid[i-1][j]==1) {
                        int nextIndex = (i-1)*n+j;
                        if(size[nextIndex] == 0) {
                            parent[nextIndex] = nextIndex;
                            size[nextIndex] = 1;
                        }
                        union(index, nextIndex);
                    } 
                    if((j+1 < n) && grid[i][j+1]==1) {
                        int nextIndex = i*n+(j+1);
                        if(size[nextIndex] == 0) {
                            parent[nextIndex] = nextIndex;
                            size[nextIndex] = 1;
                        }
                        union(index, nextIndex);
                    } 
                    if((i+1 < m) && grid[i+1][j]==1) {
                        int nextIndex = (i+1)*n+j;
                        if(size[nextIndex] == 0) {
                            parent[nextIndex] = nextIndex;
                            size[nextIndex] = 1;
                        }
                        union(index, nextIndex);
                    } 
                }
            }
        }
    }
    
    int find(int index) {
        if(index == parent[index]) return index;
        
        return parent[index] = find(parent[index]);
    }
    
    void union(int u, int v) {
        u = find(u);
        v = find(v);
        
        if(u == v) {
            return;
        }
        else {
            if(size[u] > size[v]) {
                parent[v] = u;
                size[u] += size[v];
                maxSize = Integer.max(maxSize, size[u]);
            }
            else {
                parent[u] = v;
                size[v] += size[u];
                maxSize = Integer.max(maxSize, size[v]);
            }
        }
    }
}
