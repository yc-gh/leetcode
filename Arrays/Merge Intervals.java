// https://leetcode.com/problems/merge-intervals/

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<1) return intervals;
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        List<int[]> result = new ArrayList<>();
        int[] temp = intervals[0];
        int start = temp[0];
        int end = temp[1];
        for(int[] interval : intervals)
        {
            int newStart = interval[0];
            int newEnd = interval[1];
            if(newStart>end)
            {
                result.add(new int[]{start,end});
                start = newStart;
                end = newEnd;
            }
            else
            {
                end = newEnd>end ? newEnd:end;
            }
        }
        result.add(new int[]{start,end});
        return result.toArray(new int[result.size()][]);
    }
}