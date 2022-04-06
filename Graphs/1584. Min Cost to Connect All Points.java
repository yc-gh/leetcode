//https://leetcode.com/problems/min-cost-to-connect-all-points/

//Primm's

// class Solution {
//     public int minCostConnectPoints(int[][] points) {
//         int ans = 0, n = points.length;
//         int[] dist = new int[n];
        
//         Set<Integer> mstSet = new HashSet<>();
//         mstSet.add(0);
        
//         for(int i=1; i<n; i++) {
//             dist[i] = getDist(points, 0, i);
//         }
        
//         while(mstSet.size() < n) {
//             int next = -1;
            
//             for(int i=0; i<n; i++) {
//                 if(mstSet.contains(i)) continue;
//                 if(next == -1 || dist[i] < dist[next]) next = i;
//             }
            
//             mstSet.add(next);
//             ans += dist[next];
            
//             for(int i=0; i<n; i++) {
//                 if(mstSet.contains(i)) continue;
//                 dist[i] = Math.min(dist[i], getDist(points, i, next));
//             }
//         }
        
//         return ans;
//     }
    
//     private int getDist(int[][] points, int a, int b) {
//         return Math.abs(points[a][0] - points[b][0]) + Math.abs(points[a][1] - points[b][1]);
//     }
// }

//Kruskal's
class Solution {
    
    class UnionFind {
        int[] parent, size;
        
        UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            
            for(int i=0; i<n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        
        int find(int u) {
            if(u == parent[u]) {
                return u;
            }
            
            return parent[u] = find(parent[u]);
        }
        
        void union(int u, int v) {
            u = find(u);
            v = find(v);
            
            if(u == v) {
                return;
            }
            
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
    
    public int minCostConnectPoints(int[][] points) {
        int ans = 0, n = points.length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                pq.offer(new int[]{ getDist(points, i, j), i, j });
            }
        }
        
        int numOfEdges = 0;
        UnionFind uf = new UnionFind(n);
        
        while(numOfEdges < n-1) {
            int[] edge = pq.poll();
            
            if(uf.find(edge[1]) != uf.find(edge[2])) {
                numOfEdges++;
                ans += edge[0];
                uf.union(edge[1], edge[2]);
            }
        }
        
        return ans;
    }
    
    private int getDist(int[][] points, int a, int b) {
        return Math.abs(points[a][0] - points[b][0]) + Math.abs(points[a][1] - points[b][1]);
    }
}
