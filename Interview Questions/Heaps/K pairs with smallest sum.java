//https://leetcode.com/problems/find-k-pairs-with-smallest-sums/

class Solution {   
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1=nums1.length, n2=nums2.length;
        if(n1==0 || n2==0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        boolean[][] vis = new boolean[n1][n2];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{nums1[0]+nums2[0], 0, 0});
        
        while(!pq.isEmpty() && k-->0)
        {
            int[] popped = pq.poll();
            
            res.add(Arrays.asList(nums1[popped[1]], nums2[popped[2]]));
            
            int next1 = popped[1]+1;
            int next2 = popped[2];
            
            if(next1<n1 && next2<n2)
            {
                if(!vis[next1][next2])
                {
                    int sum = nums1[next1]+nums2[next2];
                    pq.offer(new int[]{sum, next1, next2});
                    vis[next1][next2] = true;
                }
            }
            
            next1 = popped[1];
            next2 = popped[2]+1;
            
            if(next1<n1 && next2<n2)
            {
                if(!vis[next1][next2])
                {
                    int sum = nums1[next1]+nums2[next2];
                    pq.offer(new int[]{sum, next1, next2});
                    vis[next1][next2] = true;
                }
            }
            
        }
        
        return res;
    }
}
