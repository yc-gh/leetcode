//https://leetcode.com/problems/course-schedule/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) return true;
        
        List<Integer>[] graph = new ArrayList[numCourses];
        
        
        for(int[] prerequisite : prerequisites) {
            if(graph[prerequisite[0]] == null) {
                graph[prerequisite[0]] = new ArrayList<>();
            }
            graph[prerequisite[0]].add(prerequisite[1]);
        }
        
        boolean[] currVis = new boolean[numCourses];
        boolean[] vis = new boolean[numCourses];
        
        for(int[] prerequisite : prerequisites) {
            if(!dfs(prerequisite[0], graph, currVis, vis)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean dfs(int curr, List<Integer>[] graph, 
                        boolean[] currVis, boolean[] vis) {
        if(currVis[curr]) return false;
        if(vis[curr]) return true;
        if(graph[curr] == null) return true;
        
        vis[curr] = true;
        currVis[curr] = true;
        
        for(int adj : graph[curr]) {
            if(!dfs(adj, graph, currVis, vis)) {
                return false;
            }
        }

        currVis[curr] = false;
        return true;
    }
}
