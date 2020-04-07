// https://leetcode.com/problems/course-schedule/

// BFS Topological sort
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites==null || prerequisites.length==0 || prerequisites.length==1) return true;
        
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Deque<Integer> queue = new ArrayDeque<>();
        int count = 0;
        
        for(int i=0; i<numCourses; i++)
        {
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<prerequisites.length; i++)
        {
            degree[prerequisites[i][1]]++;
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        
        for(int i=0; i<numCourses; i++)
        {
            if(degree[i]==0) queue.offer(i);
        }
        
        while(!queue.isEmpty())
        {
            int curr = queue.poll();
            count++;
            
            //For topological sort
            //Print the current vertex
            
            for(int adj : graph[curr])
            {
                if(--degree[adj] == 0) queue.offer(adj);
            }
        }
        
        if(count==numCourses) return true;
        return false;
    }
}

// DFS Topological sort
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites==null || prerequisites.length==0 || prerequisites.length==1) return true;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] pair : prerequisites)
        {
            if(!map.containsKey(pair[0])) map.put(pair[0], new ArrayList<>());
            map.get(pair[0]).add(pair[1]);
        }
        boolean[] vis = new boolean[numCourses];
        boolean[] currVis = new boolean[numCourses];
        for(int i=0; i<numCourses; i++)
        {
            if(!dfs(map, i, currVis, vis)) return false;
        }
        
        //Print stack for topological sort
        
        return true;
    }
    
    static boolean dfs(Map<Integer,List<Integer>> map, int i, boolean[] currVis, boolean[] vis)
    {
        if(currVis[i]) return false;
        if(vis[i]) return true;
        vis[i] = true;
        if(!map.containsKey(i)) return true;
        currVis[i] = true;
        for(int adj : map.get(i))
        {
            if(!dfs(map, adj, currVis, vis)) return false;
        }
        currVis[i] = false;
        
        //Push current vertex to stack 
        //For topological sort
        
        return true;
    }
}



