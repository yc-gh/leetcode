//https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1#

class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        
        for(int i=0; i<start.length; i++) {
            pq.offer(new int[]{start[i], end[i]});
        }
        
        int count = 0, currEnd = -1;
        while(!pq.isEmpty()) {
            int[] currMeeting = pq.poll();
            if(currEnd == -1) {
                count++;
                currEnd = currMeeting[1];
            }
            else {
                if(currMeeting[0] > currEnd) {
                    count++;
                    currEnd = currMeeting[1]; 
                }
            }
        }
        
        return count;
    }
}
