//https://leetcode.com/problems/course-schedule/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) return true;
        
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        int visCount = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        
        for(int[] prerequisite : prerequisites) {
            if(graph[prerequisite[0]] == null) {
                graph[prerequisite[0]] = new ArrayList<>();
            }
            graph[prerequisite[0]].add(prerequisite[1]);
            indegree[prerequisite[1]]++;
        }
        
        for(int i=0; i<numCourses; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            visCount++;
            if(graph[curr] != null) {
                for(int adj : graph[curr]) {

                    if(--indegree[adj] == 0) {
                        queue.offer(adj);
                    }
                }
            }
        }
        
        if(visCount != numCourses) {
            return false;
        }
        
        return true;
    }
    
}
