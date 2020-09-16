//https://leetcode.com/problems/all-paths-from-source-to-target/

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if(graph==null || graph.length==0) return new ArrayList<>();
        
        // List<List<Integer>> res = new ArrayList<>();
        // List<Integer> path = new ArrayList<>();
        // path.add(0);
        // dfs(graph, 0, res, path);
        
        return dfsMemo(graph, 0, new HashMap<Integer, List<List<Integer>>>());
    }
    
    private void dfs(int[][] graph, int curr, List<List<Integer>> res, List<Integer> path)
    {
        if(curr == graph.length-1)
        {
            res.add(new ArrayList<>(path));
            return;
        }
              
        for(int adj : graph[curr])
        {
                path.add(adj);
                dfs(graph, adj, res, path);
                path.remove(path.size()-1);
        }
    }
    
    private List<List<Integer>> dfsMemo(int[][] graph, int curr, Map<Integer, List<List<Integer>>> map)
    {
        if(map.containsKey(curr)) 
        {
            return map.get(curr);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        
        if(curr == graph.length-1)
        {
            List<Integer> path = new ArrayList<>();
            path.add(curr);
            res.add(path);
        }
        else
        {
            for(int adj : graph[curr])
            {
                List<List<Integer>> memPath = dfsMemo(graph, adj, map);
                for(List<Integer> path : memPath)
                {
                    List<Integer> newPath = new ArrayList<>(path);
                    newPath.add(0,curr);
                    res.add(newPath);
                }
            }
        }
        
        map.put(curr, res);
        return res;
    }
}
