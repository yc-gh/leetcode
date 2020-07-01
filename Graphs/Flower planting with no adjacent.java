//https://leetcode.com/problems/flower-planting-with-no-adjacent/

class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
        Set<Integer>[] adj = new HashSet[N];
        
        int[] flowers = new int[N];

        for(int[] path : paths)
        {
            if(adj[path[0]-1]==null) adj[path[0]-1] = new HashSet<>();
            adj[path[0]-1].add(path[1]-1);
            if(adj[path[1]-1]==null) adj[path[1]-1] = new HashSet<>();
            adj[path[1]-1].add(path[0]-1);
        }
        
        for(int i=0; i<N; i++)
        {
            boolean[] usedColors = new boolean[5];
            if(adj[i]!=null)
            {
                for(int adjGarden : adj[i])
                {
                    usedColors[flowers[adjGarden]] = true;
                }
            }
            
            for(int c=1; c<=4; c++)
            {
                if(!usedColors[c]) 
                {
                    flowers[i] = c;
                    break;
                }
            }
            
        }

        return flowers;
    }
}
