//https://leetcode.com/problems/meeting-rooms-ii/

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length==0) return 0;
        
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        pq.offer(intervals[0][1]);
        
        for(int i=1; i<intervals.length; i++)
        {
            if(pq.peek() <= intervals[i][0]) pq.poll();
            
            pq.offer(intervals[i][1]);
        }
        
        return pq.size();
    }
}
