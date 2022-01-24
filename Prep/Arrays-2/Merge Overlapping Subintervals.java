//https://leetcode.com/problems/merge-intervals/

class Solution {
    public int[][] merge(int[][] intervals) {
        
        
        List<int[]> list = new ArrayList<>();
        
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        int n = intervals.length;
        int currStart = intervals[0][0];
        int currEnd  = intervals[0][1];
        
        for(int i=1; i<n; i++) {
            if(intervals[i][0] <= currEnd) {
                if(intervals[i][1] >= currEnd) {
                    currEnd = intervals[i][1];
                }
            }
            else {
                list.add(new int[]{currStart, currEnd});
                currStart = intervals[i][0];
                currEnd = intervals[i][1];
            }
        }
        
        list.add(new int[]{currStart, currEnd});
                
        return list.toArray(new int[list.size()][2]);
    }
}
