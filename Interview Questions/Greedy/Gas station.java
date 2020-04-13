// https://leetcode.com/problems/gas-station

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //Can keep start end anywhere 
        //Then loop for start!=end
        int start = gas.length-1;
        int end = 0;
        int remgas = gas[start]-cost[start];
        while(start>end)
        {
            if(remgas>=0)
            {
                remgas += gas[end]-cost[end];
                ++end;
            }
            else
            {
                --start;
                remgas += gas[start]-cost[start];
            }
        }
        
        return remgas>=0 ? start : -1;
    }
}