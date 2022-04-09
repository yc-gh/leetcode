//https://leetcode.com/problems/network-delay-time/

class Solution {
    
    public int networkDelayTime(int[][] times, int n, int k) {
        return floydwarshall(times, n, k);
    }
    
    public int djikstra(int[][] times, int n, int k) {
        Set<Integer> spSet = new HashSet<>();
        
        int[] travelTime = new int[n+1];
        int maxTravelTime = 0;
        
        for(int i=1; i<=n; i++) {
            if(i != k) {
                travelTime[i] = Integer.MAX_VALUE;
            }
        }
        
        for(int count = 0; count < n-1; count++) {
            int source = minTravelTimeIndex(travelTime, spSet);
            
            spSet.add(source);
            
            for(int i=0; i<times.length; i++) {
                if(times[i][0] == source) {
                    int destination = times[i][1];
                    int travelTimeBetween = times[i][2];
                    if(!spSet.contains(destination) && 
                       (travelTime[source] != Integer.MAX_VALUE) && 
                       (travelTime[source] + travelTimeBetween < travelTime[destination])
                      ) {
                            travelTime[destination] = travelTime[source] + travelTimeBetween;
                    }
                }
            }
        }
        
        for(int i=1; i<=n; i++) {
            if(travelTime[i] > maxTravelTime) maxTravelTime = travelTime[i];
        }
        
        return maxTravelTime == Integer.MAX_VALUE ? -1 : maxTravelTime;
    }
    
    private int minTravelTimeIndex(int[] travelTime, Set<Integer> spSet) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        
        for(int i=1; i<travelTime.length; i++) {
            if(!spSet.contains(i)) {
                if(travelTime[i] <= min) {
                    min = travelTime[i];
                    minIndex = i;
                }
            }
        }
        
        return minIndex;
    }
    
    public int bellmanford(int[][] times, int n, int k) {
        int maxTravelTime = -1;
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        
        for(int i=1; i<=n; i++) {
            for(int[] time : times) {
                int source = time[0];
                int destination = time[1];
                int weight = time[2];
                
                if(dist[source] != Integer.MAX_VALUE && (dist[destination] > dist[source] + weight)) {
                    dist[destination] = dist[source] + weight;
                }
            }
        }
        
        for(int i=1; i<=n; i++) {
            maxTravelTime = Integer.max(maxTravelTime, dist[i]);
        }
        
        return maxTravelTime == Integer.MAX_VALUE ? -1 : maxTravelTime;
    }
    
    public int floydwarshall(int[][] times, int n, int r) {
        int[][] dist = new int[n+1][n+1];
        
        for(int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        
        for(int[] time : times) {
            dist[time[0]][time[1]] = time[2];
        }
        
        for(int i=1; i<=n; i++) {
            dist[i][i] = 0;
        }
        
        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        if(dist[i][j] > dist[i][k] + dist[k][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    } 
                }
            }
        }
        
        int maxDist = Integer.MIN_VALUE;
        
        for(int i=1; i<=n; i++) {
            if(dist[r][i] == Integer.MAX_VALUE) return -1;
            maxDist = Math.max(maxDist, dist[r][i]);
        }
        
        return maxDist;
    }
}
