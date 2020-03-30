// https://leetcode.com/problems/4sum-ii/

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : C)
        {
            for(int j : D)
            {
                int sum = i+j;
                map.put(sum, map.getOrDefault(sum,0)+1);
            }
        }
        
        for(int i : A)
        {
            for(int j : B)
            {
                int sum = -(i+j);
                count += map.getOrDefault(sum, 0);
            }
        }
        return count;
    }
}