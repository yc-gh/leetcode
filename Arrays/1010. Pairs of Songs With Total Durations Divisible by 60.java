//https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] map = new int[61];
        
        int count = 0;
        
        for(int t : time) {
            int modValue = (t % 60);
            int searchVal = (60 - (t % 60)) % 60;
            count += map[searchVal];
            map[modValue]++;
        }
        
        return count;
    }
}
