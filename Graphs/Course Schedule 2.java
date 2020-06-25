// https://leetcode.com/problems/course-schedule-ii/

// DFS Topological sort
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses==0) return new int[]{0};
        if(prerequisites==null || prerequisites.length==0)
        {
            int[] output = new int[numCourses];
            for(int i=0; i<numCourses; i++) output[i] = i;
            return output;
        }
        
        ArrayList[] graph = new ArrayList[numCourses];
        
        for(int i=0; i<numCourses; i++)
        {
            graph[i] = new ArrayList<Integer>();
        }
        
        
        for(int i=0; i<prerequisites.length; i++)
        {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        boolean[] vis = new boolean[numCourses];
        boolean[] currvis = new boolean[numCourses];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<numCourses; i++)
        {
            if(!vis[i] && !topoSort(graph, i, vis, currvis, stack)) return new int[0];
        }
        int[] output = new int[numCourses];
        for(int i=0; !stack.isEmpty(); i++)
        {
            output[i] = stack.pop();
        }
        return output;
    }
    
    static boolean topoSort(List<Integer>[] graph, int curr, boolean[] vis, boolean[] currvis, Deque<Integer> stack)
    {
        if(currvis[curr]) return false;
        if(vis[curr]) return true;
        vis[curr] = true;
        currvis[curr] = true;
        for(int adj : graph[curr])
        {
            if(!topoSort(graph, adj, vis, currvis, stack)) return false;
        }
        currvis[curr] = false;
        stack.push(curr);
        return true;
    }
    
}

// BFS Topo Sort Kahn's Algo
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses==0) return new int[]{0};
        if(prerequisites==null || prerequisites.length==0)
        {
            int[] output = new int[numCourses];
            for(int i=0; i<numCourses; i++) output[i] = i;
            return output;
        }
        
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Deque<Integer> queue = new ArrayDeque<>();
        int[] output = new int[numCourses];
        int count=0, k=0;
        
        for(int i=0; i<numCourses; i++)
        {
            graph[i] = new ArrayList<Integer>();
        }
        
        for(int i=0; i<prerequisites.length; i++)
        {
            degree[prerequisites[i][0]]++;
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
                   
        for(int i=0; i<numCourses; i++)
        {
            if(degree[i]==0) queue.offer(i);
        }

        while(!queue.isEmpty())
        {
            int curr = queue.poll();
            count++;
            
            output[k++] = curr;
            
            for(int adj : graph[curr])
            {
                if(--degree[adj]==0) queue.offer(adj);
            }
        }
        
        if(count==numCourses) return output;
        return new int[0];
    }
}

