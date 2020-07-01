//https://leetcode.com/problems/find-the-town-judge/

class Solution {
    public int findJudge(int N, int[][] trust) {
//         int[] inDegree = new int[N+1];
//         int[] outDegree = new int[N+1];
        
//         for(int[] pair : trust)
//         {
//             outDegree[pair[0]]++;
//             inDegree[pair[1]]++;
//         }
        
//         for(int i=1; i<=N; i++)
//         {
//             if(outDegree[i]==0 && inDegree[i]==N-1) return i;
//         }
        
//         return -1;
        
        int[] count = new int[N+1];
        
        for(int[] pair : trust)
        {
            count[pair[0]]--;
            count[pair[1]]++;
        }
        
        for(int i=1; i<=N; i++)
        {
            if(count[i]==N-1) return i;
        }
        
        return -1;
    }
}
