//https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        
        for(int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        
        for(int[] edge : edges) {
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }
        
        for(int i=0; i<n; i++) {
            dist[i][i] = 0;
        }
        
        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        if(dist[i][j] > dist[i][k] + dist[k][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }
        }
        
        int minCount = Integer.MAX_VALUE, minCity = -1;
        
        for(int i=0; i<n; i++) {
            int tempCount = 0;
            
            for(int j=0; j<n; j++) {
                if(i != j && dist[i][j] <= distanceThreshold) {
                    tempCount++;
                }
            }
            
            if(tempCount <= minCount) {
                minCount = tempCount;
                minCity = i;
            }
        }
        
        return minCity;
    }
}
