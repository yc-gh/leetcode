//https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/

class Solution {
    
    public int removeStones(int[][] stones) {
        return dfs(stones);
    }
    
    private int dfs(int[][] stones) {
        int n = stones.length;
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int x1 = stones[i][0];
                int y1 = stones[i][1];
                int x2 = stones[j][0];
                int y2 = stones[j][1];
                
                if(x1 == x2 || y1 == y2) {
                    graph.putIfAbsent(i, new ArrayList<>());
                    List<Integer> adjList = graph.get(i);
                    adjList.add(j);
                }
            }
        }
        
        int componentCount = 0;
        
        for(int i : graph.keySet()) {
            if(!visited[i]) {
                componentCount++;
                dfsUtil(graph, i, visited);
            }
        }
        
        return n - componentCount;
    }
    
    private void dfsUtil(Map<Integer, List<Integer>> graph, int curr, boolean[] visited) {
        if(visited[curr]) return;
        
        visited[curr] = true;
        
        for(int adj : graph.get(curr)) {
            dfsUtil(graph, adj, visited);
        }
    }
    
    private int unionFindApproach(int[][] stones) {
        int n = stones.length;
        
        UnionFind uf = new UnionFind();
         
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int x1 = stones[i][0];
                int y1 = stones[i][1];
                int x2 = stones[j][0];
                int y2 = stones[j][1];
                
                if(x1 == x2 || y1 == y2) {
                    uf.union(i, j);
                }
            }
        }
        
        int componentsCount = 0;
        
        for(int i=0; i<n; i++) {
            if(uf.find(i) == i) componentsCount++;
        }
        
        return n - componentsCount;
    }
    
        class UnionFind {
        Map<Integer,Integer> parent, size;
        
        UnionFind() {
            parent = new HashMap<>();
            size = new HashMap<>();
        }
        
        int find(int u) {
            parent.putIfAbsent(u, u);
            size.putIfAbsent(u, 1);
            
            if(u == parent.get(u)) {
                return u;
            }
            
            parent.put(u, find(parent.get(u)));
            
            return parent.get(u);
        }
        
        void union(int u, int v) {
            u = find(u);
            v = find(v);
            
            if(u == v) return;
            
            size.putIfAbsent(u, 1);
            size.putIfAbsent(v, 1);
            
            if(size.get(u) < size.get(v)) {
                parent.put(u, v);
                size.put(v, size.get(v) + size.get(u));
            }
            else {
                parent.put(v, u);
                size.put(u, size.get(u) + size.get(v));
            }
        }
    }
}
