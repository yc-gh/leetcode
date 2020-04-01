// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

// Binary search 
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int low=matrix[0][0], high=matrix[matrix.length-1][matrix[0].length-1]+1;
        while(low<high)
        {
            int mid = low + (high-low)/2;
            int count = 0, j=matrix.length-1;
            for(int i=0; i<matrix.length; i++)
            {
                while(j>=0 && matrix[i][j]>mid) j--;
                count += (j+1);
            }
            if(count<k) low = mid+1;
            else high = mid;
        }
        return low;
    }
}

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