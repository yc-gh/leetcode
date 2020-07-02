//https://leetcode.com/problems/jump-game-iii/

class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        
        boolean[] vis = new boolean[n];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        
        while(!queue.isEmpty())
        {
            int curr = queue.poll();
            vis[curr] = true;
            int ele = arr[curr];
            if(ele==0) return true;
            if(curr-ele>=0 && !vis[curr-ele]) queue.offer(curr-ele);
            if(curr+ele<n && !vis[curr+ele]) queue.offer(curr+ele);
        }
        
        return false;
    }
}
