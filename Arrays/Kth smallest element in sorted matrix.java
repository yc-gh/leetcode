// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

// Binary search TODO

// Heap 
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x,y)->x.val-y.val);
        for(int i=0; i<n; i++)
        {
            pq.offer(new Tuple(0, i, matrix[0][i]));
        }
        for(int i=1; i<k; i++)
        {
            Tuple curr = pq.poll();
            if(curr.x == n-1) continue;
            pq.offer(new Tuple(curr.x+1, curr.y, matrix[curr.x+1][curr.y]));
        }
        return pq.poll().val;
    }
    
    static class Tuple
    {
        int x,y,val;
        Tuple(int x, int y, int val)
        {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}